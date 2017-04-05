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
 * Constants used in logs.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public interface LogConstants {

    /**
     * Default tag for {@link Logger}s
     */
    String TAG = "Comapi";

    /**
     * See {@link LogLevel#FATAL}
     */
    String TAG_FATAL = "[FATAL]";

    /**
     * See {@link LogLevel#ERROR}
     */
    String TAG_ERROR = "[ERROR]";

    /**
     * See {@link LogLevel#WARNING}
     */
    String TAG_WARNING = "[WARNING]";

    /**
     * See {@link LogLevel#INFO}
     */
    String TAG_INFO = "[INFO]";

    /**
     * See {@link LogLevel#DEBUG}
     */
    String TAG_DEBUG = "[DEBUG]";

}
