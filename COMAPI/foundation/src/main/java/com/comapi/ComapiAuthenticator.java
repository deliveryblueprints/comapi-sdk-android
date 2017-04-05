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

package com.comapi;

import com.comapi.internal.network.AuthClient;
import com.comapi.internal.network.ChallengeOptions;

/**
 * Implementation of this interface will be used to obtain authentication token. Can be set when initialising.
 *
 * Created by Marcin Swierczek
 * @since 1.0.0
 */
public abstract class ComapiAuthenticator {

    /**
     * Timeout interval for authentication challenges in seconds.
     */
    private static final long TIMEOUT = 60 * 5;

    /**
     * This method will be called whenever SDK will try to authenticate user on the networkLevel.
     *
     * @param authClient       Pass the authentication token to {@link AuthClient#authenticateWithToken(String)} method
     * @param challengeOptions Encapsulates challenge details - nonce, and expected user id for the token.
     */
    public abstract void onAuthenticationChallenge(final AuthClient authClient, final ChallengeOptions challengeOptions);

    /**
     * Returns timeout interval for authentication challenges.
     *
     * @return Timeout interval for authentication challenges.
     */
    public long timeoutSeconds() {
        return TIMEOUT;
    }

}
