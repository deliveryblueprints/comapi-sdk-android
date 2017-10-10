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

package com.comapi.internal.log;

/**
 * Level of logging that Comapi SDK will apply. Values stored here are used in {@link Logger} class to determine
 * if the message should be logged.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public enum LogLevel {

    /**
     * Will not log anything in this mode.
     */
    OFF(LogLevelConst.OFF),

    /**
     * Severe runtime exception.
     */
    FATAL(LogLevelConst.FATAL),

    /**
     * Runtime errors or unexpected conditions.
     */
    ERROR(LogLevelConst.ERROR),

    /**
     * Runtime situations that are undesirable or unexpected, but may not require intervention.
     */
    WARNING(LogLevelConst.WARNING),

    /**
     * Interesting runtime events.
     */
    INFO(LogLevelConst.INFO),

    /**
     * Verbose runtime information for debugging purpose.
     */
    DEBUG(LogLevelConst.DEBUG);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    /**
     * Gets log level value defined as this enum.
     *
     * @return Integer representation of this enum.
     */
    public int getValue() {
        return value;
    }
}
