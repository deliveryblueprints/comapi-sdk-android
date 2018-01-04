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

import com.comapi.internal.helpers.DateHelper;

/**
 * Formats the log entry for file log appender.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
class FormatterFileLog extends Formatter {

    /**
     * Format log data into a log entry String.
     *
     * @param msgLogLevel Log level of an entry.
     * @param tag         Tag with SDK and version details.
     * @param msg         Log message.
     * @param exception   Exception with a stach
     * @return Formatted log entry.
     */
    String formatMessage(int msgLogLevel, String tag, String msg, Throwable exception) {
        if (exception != null) {
            return DateHelper.getUTC(System.currentTimeMillis()) + "/" + getLevelTag(msgLogLevel) + tag + ": " + msg + "\n" + getStackTrace(exception) + "\n";
        } else {
            return DateHelper.getUTC(System.currentTimeMillis()) + "/" + getLevelTag(msgLogLevel) + tag + ": " + msg + "\n";
        }
    }

    /**
     * Gets stacktrace as a String.
     *
     * @param exception Exception for which the stacktrace should be returned.
     * @return Stacktrace as a String.
     */
    private String getStackTrace(final Throwable exception) {

        if (exception != null) {

            StringBuilder sb = new StringBuilder();

            StackTraceElement[] stackTrace = exception.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                sb.append(element.toString());
                sb.append('\n');
            }

            if (exception.getCause() != null) {

                StackTraceElement[] stackTraceCause = exception.getCause().getStackTrace();
                for (StackTraceElement element : stackTraceCause) {
                    sb.append(element.toString());
                    sb.append('\n');
                }

            }

            return sb.toString();
        }

        return null;
    }
}
