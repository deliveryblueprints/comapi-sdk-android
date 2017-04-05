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

/**
 * Describes the state of COMAPI SDK.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public interface GlobalState {

    /**
     * COMAPI SDK has not been initialised.
     */
    int NOT_INITIALISED = 1;

    /**
     * COMAPI SDK is initialising.
     */
    int INITIALISING = 2;

    /**
     * COMAPI SDK has been initialised but not registered.
     */
    int INITIALISED = 3;

    /**
     * COMAPI SDK has been initialised and session is loaded but is not active.
     */
    int SESSION_OFF = 4;

    /**
     * COMAPI SDK is creating and/or authenticating session.
     */
    int SESSION_STARTING = 5;

    /**
     * COMAPI SDK has active session.
     */
    int SESSION_ACTIVE = 6;

}
