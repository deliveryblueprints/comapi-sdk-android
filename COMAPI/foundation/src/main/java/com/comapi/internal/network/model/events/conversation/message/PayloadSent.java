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

package com.comapi.internal.network.model.events.conversation.message;

import com.comapi.internal.network.model.messaging.Alert;
import com.comapi.internal.network.model.messaging.MessageContext;
import com.comapi.internal.network.model.messaging.Part;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Payload of the {@link MessageSentEvent} event.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
class PayloadSent {

    @SerializedName("messageId")
    protected String messageId;

    @SerializedName("metadata")
    protected Map<String, Object> metadata;

    @SerializedName("context")
    protected MessageContext context;

    @SerializedName("parts")
    protected List<Part> parts;

    @SerializedName("alert")
    protected Alert alert;

    /**
     * Message unique identifier
     *
     * @return Message unique identifier
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Gets message metadata.
     *
     * @return Message metadata.
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Gets message context information.
     *
     * @return Message context information.
     */
    public MessageContext getContext() {
        return context;
    }

    /**
     * Gets message parts.
     *
     * @return Message parts.
     */
    public List<Part> getParts() {
        return parts;
    }

    /**
     * Gets message alert configuration.
     *
     * @return Message alert configuration.
     */
    public Alert getAlert() {
        return alert;
    }
}
