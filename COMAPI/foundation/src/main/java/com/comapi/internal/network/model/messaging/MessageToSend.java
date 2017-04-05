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

import java.util.Map;

/**
 * Represents message that can be published on the chanel.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class MessageToSend extends BaseMessage {

    @SerializedName("alert")
    private Alert alert;

    private MessageToSend() {
        super();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        MessageToSend message;

        Builder() {
            message = new MessageToSend();
        }

        /**
         * Sets metadata to the message.
         */
        public Builder setMetadata(Map<String, Object> metadata) {
            message.metadata = metadata;
            return this;
        }

        /**
         * Adds new part of the message.
         */
        public Builder addPart(Part part) {
            message.parts.add(part);
            return this;
        }

        /**
         * Sets push alert details.
         */
        public Builder setAlert(Map<String, Object> fcm, Map<String, Object> apns) {
            message.alert = new Alert(fcm, apns);
            return this;
        }

        public MessageToSend build() {
            return message;
        }
    }
}
