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
 * Interface to be implemented by all log output implementations.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
abstract class Appender {

    /**
     * Log level used by the Appender. Possible values are defined in {@link LogLevelConst} class.
     */
    private int level = LogLevelConst.ERROR;

    /**
     * Recommended constructor.
     *
     * @param logLevel Initial log level, should be one of {@link LogLevelConst}.
     */
    Appender(final int logLevel) {
        level = logLevel;
    }

    /**
     * Write the log message to some output implementation.
     *
     * @param clazz     Name of the class that sent the log message.
     * @param logLevel  Log level, should be one of {@link LogLevelConst}.
     * @param msg       Message to be logged.
     * @param exception Optional exception to log the stacktrace.
     */
    abstract void appendLog(final String clazz, final int logLevel, final String msg, final Throwable exception);

    /**
     * Should this appender output log.
     *
     * @param logLevel Log level for a message to append.
     * @return True if the appender should append the message to output.
     */
    boolean shouldAppend(final int logLevel) {
        return level >= logLevel;
    }

    /**
     * Sets log level for log appender implementation. Only logs with {@link LogLevelConst} above it will be appended.
     *
     * @param logLevel Log level for console log appender implementation.
     */
    public void setLevel(int logLevel) {
        level = logLevel;
    }

    /**
     * Gets log level set for appender implementation.
     *
     * @return Log level set for appender implementation.
     */
    protected int getLevel() {
        return level;
    }
}