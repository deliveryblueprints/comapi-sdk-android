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

import com.comapi.internal.IMessagingListener;
import com.comapi.internal.IProfileListener;
import com.comapi.internal.IStateListener;

/**
 * Class describing the initial configuration for a {@link ComapiClient} instance.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ComapiConfig extends BaseConfig<ComapiConfig> {

    private IMessagingListener messagingListener;

    private IStateListener stateListener;

    private IProfileListener profileListener;

    /**
     * Gets Comapi message listener.
     *
     * @return Comapi message listener.
     */
    IMessagingListener getMessagingListener() {
        return messagingListener;
    }

    /**
     * Gets listener for SDK state changes.
     *
     * @return Listener for SDK state changes.
     */
    IStateListener getStateListener() {
        return stateListener;
    }

    /**
     * Gets listener for profile changes.
     *
     * @return Listener for profile changes.
     */
    IProfileListener getProfileListener() {
        return profileListener;
    }

    /**
     * Sets Comapi message listener.
     *
     * @param messagingListener Comapi Socket events listener.
     * @return Builder instance with new value set.
     */
    public <E extends MessagingListener> ComapiConfig messagingListener(E messagingListener) {
        this.messagingListener = messagingListener;
        return getThis();
    }

    /**
     * Sets listener for SDK state changes.
     *
     * @param stateListener {@link StateListener} callback for state changes.
     * @param <E>           Extends {@link StateListener}
     * @return BaseURIs instance with new value set.
     */
    public <E extends StateListener> ComapiConfig stateListener(E stateListener) {
        this.stateListener = stateListener;
        return getThis();
    }

    /**
     * Sets listener for profile changes.
     *
     * @param profileListener {@link ProfileListener} callback for profile changes.
     * @param <E>             Extends {@link ProfileListener}
     * @return BaseURIs instance with new value set.
     */
    public <E extends ProfileListener> ComapiConfig profileListener(E profileListener) {
        this.profileListener = profileListener;
        return getThis();
    }

    @Override
    protected ComapiConfig getThis() {
        return this;
    }
}