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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents message that can be published in the conversation.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class BaseMessage {

    @SerializedName("metadata")
    Map<String, Object> metadata;

    @SerializedName("parts")
    List<Part> parts;

    BaseMessage() {
        parts = new LinkedList<>();
    }

    /**
     * Custom message metadata (sent when client sends a message)
     *
     * @return Custom message metadata (sent when client sends a message)
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Parts of the message with data, type, name and size
     *
     * @return Parts of the message with data, type, name and size
     */
    public List<Part> getParts() {
        return parts;
    }
}