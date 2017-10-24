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

package com.comapi.internal.network.model.messaging;

import com.google.gson.annotations.SerializedName;

/**
 * Response to unload content request. Returnes details about stored content data.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class UploadContentResponse {

    @SerializedName("folder")
    private String folder;

    @SerializedName("id")
    private String id;

    @SerializedName("size")
    private Long size;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    /**
     * Folder informs about internal categorisation of the file.
     *
     * @return Folder name on server storage.
     */
    public String getFolder() {
        return folder;
    }

    /**
     * Id of uploaded file.
     *
     * @return Id of uploaded file.
     */
    public String getId() {
        return id;
    }

    /**
     * Size of uploaded data.
     *
     * @return Size of uploaded data.
     */
    public Long getSize() {
        return size;
    }

    /**
     * a
     * Mime Type of uploaded data.
     *
     * @return Mime Type of uploaded data.
     */
    public String getType() {
        return type;
    }

    /**
     * Url pointing to the stored file.
     *
     * @return Url pointing to the stored file.
     */
    public String getUrl() {
        return url;
    }
}