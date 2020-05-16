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
package fi.vm.kapa.rova.client.xroad;

import fi.vm.kapa.rova.client.model.Authorization;
import fi.vm.kapa.rova.client.model.AuthorizationList;

import java.util.Set;

/**
 * Client interface for fetching information required when working on behalf of an other person.
 */
public interface HpaXRoadClient {
    /**
     * @param userId      user identifier
     * @param delegateId  personal identification number of delegate
     * @param principalId personal identification number of principal
     * @param issue       possible issues that should be checked
     * @return boolean value if delegate is authorized or not
     */
    Authorization isAuthorized(String userId, String delegateId, String principalId, Set<String> issue);

    /**
     * @param userId      user identifier
     * @param delegateId  personal identification number of delegate
     * @param principalId personal identification number of principal
     * @return AuthorizationList containing authorization roles for delegate on behalf of principal
     */
    AuthorizationList getAuthorizationList(String userId, String delegateId, String principalId);
}
