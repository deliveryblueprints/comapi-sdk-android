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
 * Represents message published int the conversation.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class MessageReceived extends BaseMessage {

    @SerializedName("id")
    private String id;

    @SerializedName("sentEventId")
    private Long sentEventId;

    @SerializedName("context")
    private MessageContext messageContext;

    @SerializedName("statusUpdates")
    private Map<String, Status> statusUpdates;

    /**
     * Message unique identifier.
     *
     * @return Message unique identifier.
     */
    public String getMessageId() {
        return id;
    }

    /**
     * Unique, monotonically increasing number of event of this message and conversation.
     *
     * @return Unique, monotonically increasing number of event of this message and conversation.
     */
    public Long getSentEventId() {
        return sentEventId;
    }

    /**
     * Message sender
     *
     * @return Message sender
     */
    public Sender getFromWhom() {
        return messageContext != null ? messageContext.getFromWhom() : null;
    }

    /**
     * Message sender defined internally on server (shouldn't be visible inside the app).
     *
     * @return Message sender defined internally on server (shouldn't be visible inside the app).
     */
    public String getSentBy() {
        return messageContext != null ? messageContext.getSentBy() : null;
    }

    /**
     * When the message was sent.
     *
     * @return When the message was sent.
     */
    public String getSentOn() {
        return messageContext != null ? messageContext.getSentOn() : null;
    }

    /**
     * Conversation unique identifier.
     *
     * @return Conversation unique identifier.
     */
    public String getConversationId() {
        return messageContext != null ? messageContext.getConversationId() : null;
    }

    /**
     * Key is the profile identifier the value is either 'delivered' or 'read'.
     *
     * @return Key is the profile identifier the value is either 'delivered' or 'read'.
     */
    public Map<String, Status> getStatusUpdate() {
        return statusUpdates;
    }

    public class Status {

        @SerializedName("status")
        protected String status;

        @SerializedName("on")
        protected String timestamp;

        /**
         * Message status 'delivered' or 'read'
         *
         * @return Message status 'delivered' or 'read'
         */
        public MessageStatus getStatus() {
            if (MessageStatus.delivered.name().equals(status)) {
                return MessageStatus.delivered;
            } else if (MessageStatus.read.name().equals(status)) {
                return MessageStatus.read;
            }
            return null;
        }

        /**
         * When the message was sent.
         *
         * @return When the message was sent.
         */
        public String getTimestamp() {
            return timestamp;
        }
    }
}
