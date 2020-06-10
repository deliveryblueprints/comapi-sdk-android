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

import com.comapi.internal.CallbackAdapter;
import com.comapi.internal.IStateListener;
import com.comapi.internal.log.LogConfig;
import com.comapi.internal.push.PushMessageListener;
import com.comapi.internal.IProfileListener;
import com.comapi.internal.push.PushTokenProvider;

/**
 * Base class for Comapi configuration and setup.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public abstract class BaseConfig<T extends BaseConfig<T>> {

    protected LogConfig logConfig;

    protected ComapiAuthenticator authenticator;

    protected PushMessageListener pushMessageListener;

    protected String apiSpaceId;

    protected CallbackAdapter callbackAdapter;

    protected int logSizeLimit;

    protected APIConfig apiConfig;

    private PushTokenProvider pushTokenProvider;

    protected boolean fcmEnabled = true;

    /**
     * Gets Comapi ApiSpace identifier.
     *
     * @return Comapi ApiSpace identifier.
     */
    public String getApiSpaceId() {
        return apiSpaceId;
    }

    /**
     * Gets Comapi logging configuration.
     *
     * @return Comapi logging configuration.
     */
    public LogConfig getLogConfig() {
        return logConfig;
    }

    /**
     * Gets Authenticator to set a response for authentication challenges.
     *
     * @return Authenticator to set a response for authentication challenges.
     */
    ComapiAuthenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * Gets Comapi message listener.
     *
     * @return Comapi message listener.
     */
    PushMessageListener getPushMessageListener() {
        return pushMessageListener;
    }

    /**
     * Gets observables to callbacks adapter.
     *
     * @return Observables to callbacks adapter.
     */
    protected CallbackAdapter getCallbackAdapter() {
        return callbackAdapter;
    }

    /**
     * Gets total file size limit for internal logs.
     *
     * @return Total file size limit for internal logs.
     */
    int getLogSizeLimit() {
        return logSizeLimit;
    }

    /**
     * Gets API URLs.
     *
     * @return API URLs.
     */
    APIConfig getApiConfig() {
        return apiConfig;
    }

    /**
     * Sets method of obtaining push token. Used for mocking FCM.
     *
     * @return Provides push token.
     */
    PushTokenProvider getPushTokenProvider() {
        return pushTokenProvider;
    }

    /**
     * Is Firebase Cloud Messaging configuraed and initialised. If yes the SDK will register FCM token on the server.
     *
     * @return True if Firebase Cloud Messaging is configured and initialised
     */
    public boolean isFcmEnabled() {
        return fcmEnabled;
    }

    /**
     * Sets Comapi App Space identifier.
     *
     * @param id Comapi ApiSpace identifier.
     * @return BaseURIs instance with new value set.
     */
    public T apiSpaceId(String id) {
        this.apiSpaceId = id;
        return getThis();
    }

    /**
     * Sets Comapi logging configuration.
     *
     * @param logConfig Comapi logging configuration.
     * @return BaseURIs instance with new value set.
     */
    public T logConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
        return getThis();
    }

    /**
     * Sets Comapi message listener.
     *
     * @param pushMessageListener Push message listener.
     * @return BaseURIs instance with new value set.
     */
    public T pushMessageListener(PushMessageListener pushMessageListener) {
        this.pushMessageListener = pushMessageListener;
        return getThis();
    }

    /**
     * Sets Authenticator to set a response for authentication challenges.
     *
     * @param authenticator Authenticator to set a response for authentication challenges.
     * @return BaseURIs instance with new value set.
     */
    public T authenticator(ComapiAuthenticator authenticator) {
        this.authenticator = authenticator;
        return getThis();
    }

    /**
     * Sets total file size limit for internal logs.
     *
     * @param limit Total file size limit for internal logs.
     * @return BaseURIs instance with new value set.
     */
    public T logSizeLimitKilobytes(int limit) {
        this.logSizeLimit = limit;
        return getThis();
    }

    /**
     * Sets API URLs.
     *
     * @param apiConfig API URLs configuration.
     * @return BaseURIs instance with new value set.
     */
    public T apiConfiguration(APIConfig apiConfig) {
        this.apiConfig = apiConfig;
        return getThis();
    }

    /**
     * Sets method of obtaining push token. Used for mocking FCM.
     *
     * @param pushTokenProvider Provides push token.
     * @return BaseURIs instance with new value set.
     */
    public T pushTokenProvider(PushTokenProvider pushTokenProvider) {
        this.pushTokenProvider = pushTokenProvider;
        return getThis();
    }

    /**
     * Sets if Firebase Cloud Messaging is configured and initialised. If yes the SDK will register FCM token on the server.
     *
     * @param fcmEnabled True if Firebase Cloud Messaging is configured and initialised
     */
    public T fcmEnabled(boolean fcmEnabled) {
        this.fcmEnabled = fcmEnabled;
        return getThis();
    }

    /**
     * Sets observables to callbacks adapter. By Overriding CallbackAdapter#adapt(Observable, Callback) method you can change
     * e.g. the threads on which SDK subscribe to observable when callback APIs version are being called. By default they subscribe on
     * io thread and notify on the main thread.
     *
     * @param callbackAdapter {@link CallbackAdapter} instance for APIs version with callbacks.
     * @param <E>             Extends {@link CallbackAdapter}
     * @return BaseURIs instance with new value set.
     */
    public <E extends CallbackAdapter> T overrideCallbackAdapter(E callbackAdapter) {
        this.callbackAdapter = callbackAdapter;
        return getThis();
    }

    protected abstract T getThis();
}
