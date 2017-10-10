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

    /**
     * Default constructor.
     */
    public LogConfig() {
        consoleLevel = LogLevel.WARNING;
        fileLevel = LogLevel.WARNING;
        networkLevel = LogLevel.WARNING;
    }

    /**
     * Convenience constructor to choose between most common log settings - debug and production (up to warnings).
     */
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

    /**
     * Convenience method to create debug log settings. All levels set to DEBUG.
     *
     * @return Debug log settings instance.
     */
    public static LogConfig getDebugConfig() {
        return new LogConfig(true);
    }

    /**
     * Convenience method to create production log settings. All levels set to WARNING.
     *
     * @return Production log settings instance.
     */
    public static LogConfig getProductionConfig() {
        return new LogConfig(false);
    }

    /**
     * Gets level of console logs. Only logs up to this level will be displayed in a console.
     *
     * @return Console logs level.
     */
    public LogLevel getConsoleLevel() {
        return consoleLevel;
    }

    /**
     * Set log level for the console logs.
     *
     * @param consoleLevel Log level for the console logs.
     * @return Log configuration.
     */
    public LogConfig setConsoleLevel(LogLevel consoleLevel) {
        this.consoleLevel = consoleLevel;
        return this;
    }

    /**
     * Gets level of console logs. Only logs up to this level will be displayed in a console.
     *
     * @return Console logs level.
     */
    public LogLevel getFileLevel() {
        return fileLevel;
    }

    /**
     * Set log level for the file logs.
     *
     * @param fileLevel Log level for the console logs.
     * @return Log configuration.
     */
    public LogConfig setFileLevel(LogLevel fileLevel) {
        this.fileLevel = fileLevel;
        return this;
    }

    /**
     * Gets level of logs for network communication. SDK will recognise only DEBUG level in which case
     *
     * @return Console logs level.
     */
    public LogLevel getNetworkLevel() {
        return networkLevel;
    }

    /**
     * Set log level for the console logs.
     *
     * @param networkLevel Log level for the console logs.
     * @return Log configuration.
     */
    public LogConfig setNetworkLevel(LogLevel networkLevel) {
        this.networkLevel = networkLevel;
        return this;
    }
}
