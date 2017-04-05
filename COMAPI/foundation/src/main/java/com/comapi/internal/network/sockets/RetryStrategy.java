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

package com.comapi.internal.network.sockets;

/**
 * Definition of a strategy for socket reconnection when an error occurs.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
class RetryStrategy {

    private int maxRetries;

    private int maximumDelay;

    private int retries;

    /**
     * Recommended constructor.
     *
     * @param maxRetries MAx retries allowed for failing socket connection.
     */
    RetryStrategy(int maxRetries, int maximumDelay) {
        this.maxRetries = maxRetries;
        this.maximumDelay = maximumDelay;
    }

    /**
     * @return True if maximum of retries was not reached. Increments the retry counter.
     */
    boolean retry() {
        retries += 1;
        return retries <= maxRetries;
    }

    /**
     * Resets the retry counter.
     */
    void reset() {
        retries = 0;
    }

    /**
     * @return Delay before next retry in milliseconds.
     */
    long getDelay() {
        return Math.min(1000*retries, maximumDelay);
    }
}