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

package com.comapi.internal.network;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Content data object.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ContentData {

    private RequestBody body;

    /**
     * Create data object to send from a file.
     *
     * @param data File to upload.
     * @param type Mime type of the data.
     * @return Data object to send.
     */
    public static ContentData create(File data, String type) {
        return new ContentData(RequestBody.create(MediaType.parse(type), data));
    }

    /**
     * Create data object to send from a file.
     *
     * @param data Raw data bytes to upload.
     * @param type Mime type of the data.
     * @return Data object to send.
     */
    public static ContentData create(byte[] data, String type) {
        return new ContentData(RequestBody.create(MediaType.parse(type), data));
    }

    /**
     * Create data object to send from a file.
     *
     * @param data Base64 encoded data to upload.
     * @param type Mime type of the data.
     * @return Data object to send.
     */
    public static ContentData create(String data, String type) {
        return new ContentData(RequestBody.create(MediaType.parse(type), data));
    }

    private ContentData(RequestBody body) {
        this.body = body;
    }

    /**
     * Request body for REST API to upload the content data.
     *
     * @return Request body for REST API.
     */
    RequestBody getBody() {
        return body;
    }
}
