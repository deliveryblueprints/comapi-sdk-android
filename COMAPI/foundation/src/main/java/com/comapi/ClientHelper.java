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

import com.comapi.internal.lifecycle.LifecycleListener;
import com.comapi.internal.log.Logger;
import com.comapi.internal.network.api.RxComapiService;

/**
 * Wrapper class for client to access methods needed by COMAPI extension modules. This class should be used only by COMAPI modules and doesn't contain supported public APIs.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ClientHelper {

    /**
     * Gets logger to access internal logs writer. Convenience method for chat layer.
     *
     * @param client COMAPI client.
     * @return Internal logger instance.
     */
    public static Logger getLogger(RxComapiClient client) {
        return client.getLogger();
    }

    /**
     * Adds listener for application lifecycle callbacks. Convenience method for chat layer.
     *
     * @param client COMAPI client.
     * @param listener Listener for application lifecycle callbacks.
     */
    public static void addLifecycleListener(RxComapiClient client, LifecycleListener listener) {
        client.addLifecycleListener(listener);
    }

    /**
     * Entire service interface. Convenience method for chat layer.
     *
     * @param client COMAPI client.
     * @return Service interface.
     */
    public static RxComapiService getComapiService(RxComapiClient client) {
        return client.getComapiService();
    }

    public static void resetShared() {
        RxComapi.reset();
    }

    public static void resetChecks() {
        Comapi.reset();
        RxComapi.reset();
    }
}
