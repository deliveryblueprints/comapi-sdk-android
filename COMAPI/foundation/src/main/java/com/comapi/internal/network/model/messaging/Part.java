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
 * Part of the message.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class Part {

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("data")
    private String data;

    @SerializedName("size")
    private long size;

    /**
     * Message part name
     *
     * @return Message part name
     */
    public String getName() {
        return name;
    }

    /**
     * Message part type
     *
     * @return Message part type
     */
    public String getType() {
        return type;
    }

    /**
     * Message part url
     *
     * @return Message part url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Message part data
     *
     * @return Message part data
     */
    public String getData() {
        return data;
    }

    /**
     * Message part size
     *
     * @return Message part size
     */
    public long getSize() {
        return size;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        Part part;

        public Builder() {
            part = new Part();
        }

        /**
         * Sets the name of the message part.
         */
        public Builder setName(String name) {
            part.name = name;
            return this;
        }

        /**
         * Sets the type of the message part.
         */
        public Builder setType(String type) {
            part.type = type;
            return this;
        }

        /**
         * Sets url.
         */
        public Builder setUrl(String url) {
            part.url = url;
            return this;
        }

        /**
         * Sets the message data.
         */
        public Builder setData(String data) {
            part.data = data;
            return this;
        }

        /**
         * Sets the message data size.
         */
        public Builder setSize(long size) {
            part.size = size;
            return this;
        }

        public Part build() {
            return part;
        }
    }
}
