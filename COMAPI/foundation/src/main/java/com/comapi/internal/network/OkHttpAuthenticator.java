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

package com.comapi.internal.network;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


/**
 * Internal interceptor for OkHttp authentication challenges.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
class OkHttpAuthenticator implements Authenticator {

    private final static int MAX_AUTH_COUNT = 3;

    private final AuthManager mgr;

    /**
     * Recommended constructor.
     *
     * @param mgr Authentication manager
     */
    OkHttpAuthenticator(AuthManager mgr) {
        this.mgr = mgr;
    }

    @Override
    public Request authenticate(Route route, Response response) {

        if (responseCount(response) >= MAX_AUTH_COUNT) {
            return null; // If we've failed N times, give up.
        }

        //Obtain new Comapi access token and retry request with updated header.

        String credential = mgr.restartSession().toBlocking().single().getAccessToken();

        if (!credential.equals(response.request().header("Authorization"))) {

            return response.request().newBuilder()
                    .header("Authorization", AuthManager.addAuthPrefix(credential))
                    .build();
        }

        return null;
    }

    /**
     * Counts how many times we made this service call.
     *
     * @param response Service call response.
     * @return How many responses we received for this service call.
     */
    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }
}