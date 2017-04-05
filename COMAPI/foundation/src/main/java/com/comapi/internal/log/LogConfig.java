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
 * Logging levels configuration.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class LogConfig {

    private LogLevel consoleLevel;

    private LogLevel fileLevel;

    private LogLevel networkLevel;

    public LogConfig() {
        consoleLevel = LogLevel.WARNING;
        fileLevel = LogLevel.WARNING;
        networkLevel = LogLevel.WARNING;
    }

    private LogConfig(boolean isDebug) {
        if (isDebug) {
            consoleLevel = LogLevel.DEBUG;
            fileLevel = LogLevel.DEBUG;
            networkLevel = LogLevel.DEBUG;
        } else {
            consoleLevel = LogLevel.WARNING;
            fileLevel = LogLevel.WARNING;
            networkLevel = LogLevel.WARNING;
        }
    }

    public static LogConfig getDebugConfig() {
        return new LogConfig(true);
    }

    public static LogConfig getProductionConfig() {
        return new LogConfig(false);
    }

    public LogLevel getConsoleLevel() {
        return consoleLevel;
    }

    public LogConfig setConsoleLevel(LogLevel consoleLevel) {
        this.consoleLevel = consoleLevel;
        return this;
    }

    public LogLevel getFileLevel() {
        return fileLevel;
    }

    public LogConfig setFileLevel(LogLevel fileLevel) {
        this.fileLevel = fileLevel;
        return this;
    }

    public LogLevel getNetworkLevel() {
        return networkLevel;
    }

    public LogConfig setNetworkLevel(LogLevel networkLevel) {
        this.networkLevel = networkLevel;
        return this;
    }
}
