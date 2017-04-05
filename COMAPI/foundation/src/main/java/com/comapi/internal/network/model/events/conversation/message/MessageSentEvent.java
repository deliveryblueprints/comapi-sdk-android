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

import com.comapi.internal.network.model.messaging.Part;
import com.google.gson.annotations.SerializedName;

import com.comapi.internal.network.model.messaging.Alert;
import com.comapi.internal.network.model.messaging.MessageContext;

import java.util.List;
import java.util.Map;

/**
 * Event received trough socket. Message was sent to all participant in a conversation.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class MessageSentEvent extends ConversationMessageEvent {

    public static final String TYPE = "conversationMessage.sent";

    @SerializedName("payload")
    protected PayloadSent payload;

    /**
     * Message unique identifier
     *
     * @return Message unique identifier
     */
    public String getMessageId() {
        return payload != null ? payload.messageId : null;
    }

    /**
     * Custom message metadata (sent when client sends a message)
     *
     * @return Custom message metadata (sent when client sends a message)
     */
    public Map<String, Object> getMetadata() {
        return payload != null ? payload.metadata : null;
    }

    /**
     * Message context
     *
     * @return Message context
     */
    public MessageContext getContext() {
        return payload != null ? payload.context : null;
    }

    /**
     * Parts of the message with data, type, name and size
     *
     * @return Parts of the message with data, type, name and size
     */
    public List<Part> getParts() {
        return payload != null ? payload.parts : null;
    }

    /**
     * Alert definitions with FCM and APNS push platforms
     *
     * @return Alert definitions with FCM and APNS push platforms
     */
    public Alert getAlert() {
        return payload != null ? payload.alert : null;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | messageId = " + payload.getMessageId();
    }
}