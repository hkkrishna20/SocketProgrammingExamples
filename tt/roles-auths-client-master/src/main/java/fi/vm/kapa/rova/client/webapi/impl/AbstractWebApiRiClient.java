/**
 * The MIT License
 * Copyright (c) 2016 Population Register Centre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fi.vm.kapa.rova.client.webapi.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.vm.kapa.rova.client.webapi.WebApiClientConfig;
import fi.vm.kapa.rova.client.webapi.WebApiClientException;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;

public abstract class AbstractWebApiRiClient {

    protected final static String HMAC_ALGORITHM = "HmacSHA256";
    protected final WebApiClientConfig config;
    protected final String delegateId;

    private RegisterToken registerToken;

    protected String accessToken;

    private String stateParameter = UUID.randomUUID().toString();

    private static class RegisterToken {
        String sessionId;
        String userId;

        @SuppressWarnings("unused")
        void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        @SuppressWarnings("unused")
        void setUserId(String userId) {
            this.userId = userId;
        }
    }

    private boolean clientActiveState;

    public AbstractWebApiRiClient(WebApiClientConfig config, String delegateId) {
        this.config = config;
        this.delegateId = delegateId;
    }

    protected abstract String getRegisterUrl();

    protected abstract String getUnRegisterUrl(String sessionId);

    protected abstract String getTransferUrl(String sessionId);

    protected abstract String getRegisterTransferUrl(String transferToken);

    public void getToken(String codeParam, String stateParam) throws WebApiClientException {
        if (!stateParameter.equals(stateParam)) {
            clientActiveState = false;
            throw new WebApiClientException("Mismatching OAuth state parameter. Expected state=" + stateParameter);
        }

        OAuthJSONAccessTokenResponse oAuthResponse = null;
        try {
            OAuthClientRequest.TokenRequestBuilder requestBuilder = OAuthClientRequest.tokenLocation(config.getTokenUrl()).setGrantType(GrantType.AUTHORIZATION_CODE).setClientId(config.getClientId()).setClientSecret(config.getoAuthSecret()).setCode(codeParam);

            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
            oAuthResponse = oAuthClient.accessToken(requestBuilder.setRedirectURI(config.getoAuthRedirect()).buildBodyMessage(), OAuthJSONAccessTokenResponse.class);
        } catch (OAuthProblemException | OAuthSystemException e) {
            handleException("Unable to get token", e);
        }
        this.accessToken = oAuthResponse.getAccessToken();
    }

    public String getTransferToken() throws WebApiClientException {
        try {
            String sessionId = this.registerToken.sessionId;
            if (sessionId == null) {
                throw new WebApiClientException("No active session found for transfer.");
            }
            return getResultString(getTransferUrl(sessionId));
        } catch (IOException e) {
            handleException("Transfer Token fetching failed", e);
        }
        return null;
    }

    public String registerTransfer(String transferToken, String requestId, String userInterfaceLanguage) throws WebApiClientException {
        return actuallyRegister(getRegisterTransferUrl(transferToken), requestId, userInterfaceLanguage);
    }

    public String register(String requestId, String userInterfaceLanguage) throws WebApiClientException {
        return actuallyRegister(getRegisterUrl(), requestId, userInterfaceLanguage);
    }

    private String actuallyRegister(String path, String requestId, String userInterfaceLanguage) throws WebApiClientException {
        try {
            clientActiveState = true;
            String tokenStr = getResultString(getPathWithParams(path, requestId));
            ObjectMapper mapper = new ObjectMapper();
            this.registerToken = mapper.readValue(tokenStr, RegisterToken.class);

            return config.getAuthorizeUrl() //
                    + "?client_id=" + config.getClientId() //
                    + "&response_type=code"//
                    + "&requestId=" + requestId//
                    + "&user=" + this.registerToken.userId //
                    + "&state=" + stateParameter //
                    + "&redirect_uri=" + config.getoAuthRedirect() //
                    + (userInterfaceLanguage != null ? "&lang=" + userInterfaceLanguage : "");
        } catch (IOException e) {
            handleException(e);
        }
        // should not get here
        return null;
    }

    public Boolean unregister() throws WebApiClientException {
        clientActiveState = false;
        try {
            String sessionId = this.registerToken.sessionId;
            if (sessionId == null) {
                return false;
            }
            String resultString = getResultString(getUnRegisterUrl(sessionId));
            return (resultString != null && "true".equalsIgnoreCase(resultString));
        } catch (IOException e) {
            handleException("Unregisterig failed", e);
        }
        return false;
    }

    protected String getOauthSessionId() {
        return registerToken.sessionId;
    }

    protected String getAuthorizationValue(String path) throws IOException {
        String timestamp = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
        return config.getClientId() + " " + timestamp + " " + hash(path + " " + timestamp, config.getApiKey());
    }

    @SuppressWarnings("Duplicates")
    private String hash(String data, String key) throws IOException {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_ALGORITHM);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            String result = new String(Base64.getEncoder().encode(rawHmac));
            return result;
        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalStateException e) {
            throw new IOException("Cannot create hash", e);
        }
    }

    protected String getPathWithParams(String path, String requestId, String... issues) {
        StringBuilder pathBuilder = new StringBuilder(path).append("?requestId=").append(requestId);
        for (String issue : issues) {
            if (issue != null) {
                pathBuilder.append("&issues=").append(issue);
            }
        }

        return pathBuilder.toString();
    }

    protected void handleException(Throwable t) throws WebApiClientException {
        clientActiveState = false;
        throw new WebApiClientException("Got exception client now in inactive state", t);
    }

    protected void handleException(String msg, Throwable t) throws WebApiClientException {
        clientActiveState = false;
        throw new WebApiClientException(msg, t);
    }

    private String getResultString(String path) throws IOException {
        URL url = new URL(config.getBaseUrl(), path);
        HttpURLConnection yc = (HttpURLConnection) url.openConnection();
        yc.setRequestProperty("X-AsiointivaltuudetAuthorization", getAuthorizationValue(path));
        String resultString = null;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()))) {
            String s;
            while ((s = in.readLine()) != null) {
                resultString = s;
            }
        }
        return resultString;
    }

    public String getDelegateId() {
        return this.delegateId;
    }
}
