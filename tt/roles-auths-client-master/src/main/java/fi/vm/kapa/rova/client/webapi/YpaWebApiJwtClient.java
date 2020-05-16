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
package fi.vm.kapa.rova.client.webapi;

import fi.vm.kapa.rova.client.model.YpaOrganization;

import java.util.List;

/**
 * Client for YPA-api
 */
public interface YpaWebApiJwtClient extends YpaWebApiClient {

    /**
     * Get companies chosen by end user.
     *
     * @param requestId
     * @return List of organizations and user's roles in them.
     * @throws WebApiClientException
     */
    String getCompaniesToken(String requestId) throws WebApiClientException;

    /**
     * Get user's roles in given organization.
     *
     * @param requestId
     * @param organizationId
     * @return Organization and user's roles in it
     * @throws WebApiClientException
     */
    String getRolesToken(String requestId, String organizationId) throws WebApiClientException;

    /**
     * Get JWT token representing users session
     *
     * @param requestId
     * @return A token representing users ypa session.
     * @throws WebApiClientException
     */
    String getCompaniesSessionToken(String requestId) throws WebApiClientException;

    /**
     * Get companies chosen by end user.
     *
     * @param sessionJwtToken
     * @param requestId
     * @return List of organizations and user's roles in them.
     * @throws WebApiClientException
     */
    List<YpaOrganization> getSessionCompanies(String sessionJwtToken, String requestId) throws WebApiClientException;

}
