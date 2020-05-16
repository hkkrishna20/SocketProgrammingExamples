package name.javacode.webservices.jaxws.handler;

import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpBasicAuthenticationHandler extends AbstractSOAPHandler {
    private static final Logger LOGGER = LoggerFactory
	    .getLogger(HttpBasicAuthenticationHandler.class);

    private final String username;
    private final String password;

    public HttpBasicAuthenticationHandler(String username, String password) {
	if (username == null || username.length() == 0 || password == null
		|| password.length() == 0) {
	    LOGGER.error("Bad credentials supplied.");
	    throw new WebServiceException("Bad credentials supplied.");
	}

	this.username = username;
	this.password = password;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
	boolean inbound = !((Boolean) context
		.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY));

	LOGGER.debug("Inbound: {}.", inbound);

	if (inbound) {
	    @SuppressWarnings("unchecked")
	    Map<String, List<String>> requestHdrs = (Map<String, List<String>>) context
		    .get(MessageContext.HTTP_REQUEST_HEADERS);

	    if (requestHdrs == null || requestHdrs.size() == 0) {
		LOGGER.error("Bad request: Http request headers not found.");
		throw new WebServiceException(
			"Bad request: Http request headers not found.");
	    }

	    List<String> username = requestHdrs
		    .get(BindingProvider.USERNAME_PROPERTY);
	    List<String> password = requestHdrs
		    .get(BindingProvider.PASSWORD_PROPERTY);

	    if (username == null || username.size() == 0 || password == null
		    || password.size() == 0) {
		LOGGER.error("Bad request: credentials not found.");
		throw new WebServiceException(
			"Bad request: credentials not found.");
	    }

	    LOGGER.debug("Username: {}.", username.get(0));
	    LOGGER.debug("Password: {}.", maskPassword(password.get(0)));

	    if (!this.username.equals(username.get(0))
		    || !this.password.equals(password.get(0))) {
		LOGGER.error("Authentication error:  credentials did not match.");
		throw new WebServiceException(
			"Authentication error:  credentials did not match.");
	    }
	}

	return true;
    }

    private String maskPassword(String password) {
	return password;
    }
}
