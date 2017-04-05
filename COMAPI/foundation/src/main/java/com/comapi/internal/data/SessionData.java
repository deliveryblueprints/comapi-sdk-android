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

package com.comapi.internal.data;

/**
 * Active session data.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class SessionData {

    private String profileId;

    private String sessionId;

    private String accessToken;

    private long expiresOn;

    /**
     * Gets user unique identifier.
     *
     * @return User unique identifier.
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Gets identifier for a session.
     *
     * @return Identifier for a session.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Gets session authorisation token for a session.
     *
     * @return Authorisation token for a session.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Gets number of milliseconds since January 1, 1970 00:00:00 UTC in which the session is valid.
     *
     * @return Number of milliseconds since January 1, 1970 00:00:00 UTC in which the session is valid.
     */
    public long getExpiresOn() {
        return expiresOn;
    }

    /**
     * Sets user unique identifier.
     *
     * @param profileId User unique identifier.
     * @return {@link SessionData} instance with the new value.
     */
    public SessionData setProfileId(String profileId) {
        this.profileId = profileId;
        return this;
    }

    /**
     * Sets identifier for a session.
     *
     * @param sessionId Identifier for a session.
     */
    public SessionData setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    /**
     * Sets session authorisation token for a session.
     *
     * @param accessToken Authorisation token for a session.
     */
    public SessionData setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * Sets number of milliseconds since January 1, 1970 00:00:00 UTC in which the session is valid.
     *
     * @param expiresOn Number of milliseconds since January 1, 1970 00:00:00 UTC in which the session is valid.
     */
    public SessionData setExpiresOn(long expiresOn) {
        this.expiresOn = expiresOn;
        return this;
    }
}