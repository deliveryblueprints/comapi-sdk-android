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

import android.content.Context;
import android.support.annotation.NonNull;

import rx.Observable;

/**
 * Manager class for logging. Internal API for setting log levels and log messages.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class LogManager {

    private AppenderConsole aConsole;

    private AppenderFile aFile;

    /**
     * Initialise Logging manager.
     *
     * @param context      Application context.
     * @param levConsole   Log level threshold for console output.
     * @param levFile      Log level threshold for file output.
     * @param logSizeLimit Log files size limit.
     */
    public void init(@NonNull Context context, final int levConsole, final int levFile, int logSizeLimit) {
        if (levConsole != LogLevel.OFF.getValue()) {
            aConsole = new AppenderConsole(levConsole, new FormatterConsoleLog());
        }
        if (levFile != LogLevelConst.OFF) {
            aFile = new AppenderFile(context, levFile, new FormatterFileLog(), logSizeLimit);
        }
    }

    /**
     * Gets the content of internal log files.
     */
    public Observable<String> getLogs() {
        return aFile != null ? aFile.getLogs() : Observable.just(null);
    }

    /**
     * Logs message using defined appender.
     *
     * @param clazz     Name of the class from the which the log originate.
     * @param logLevel  Level of the log message.
     * @param msg       Message to be logged.
     * @param exception Optional exception to extract the stacktrace.
     */
    public void log(final String clazz, final int logLevel, final String msg, final Throwable exception) {
        if (aConsole != null) {
            aConsole.appendLog(clazz, logLevel, msg, exception);
        }
        if (aFile != null) {
            aFile.appendLog(clazz, logLevel, msg, exception);
        }
    }
}
