/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Comapi (trading name of Dynmark International Limited)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.comapi.internal.network.model.session;

import com.google.gson.annotations.SerializedName;

/**
 * Request to start the process for authenticating a new session.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class SessionStartResponse {

    @SerializedName("authenticationId")
    private String authenticationId;

    @SerializedName("provider")
    private String provider;

    @SerializedName("nonce")
    private String nonce;

    @SerializedName("expiresOn")
    private String expiresOn;

    /**
     * Gets single use authentication process id to identify currently performed authentication.
     *
     * @return Authentication process id.
     */
    public String getAuthenticationId() {
        return authenticationId;
    }

    /**
     * Gets authorisation token provider.
     *
     * @return Authentication token provider.
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Gets single use authentication id for auth provider to identify token.
     *
     * @return Authentication nonce.
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * Gets expiration time.
     *
     * @return Authentication process id.
     */
    public String getExpiresOn() {
        return expiresOn;
    }
}
