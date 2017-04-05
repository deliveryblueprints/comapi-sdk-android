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

import com.google.gson.annotations.SerializedName;

/**
 * Base class for socket events. Delivers information about message status
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class MessageUpdateEvent extends ConversationMessageEvent {

    @SerializedName("payload")
    protected PayloadStatusUpdate payload;

    /**
     * Gets id of the updated message.
     *
     * @return Id of the updated message.
     */
    public String getMessageId() {
        return payload != null ? payload.messageId : null;
    }

    /**
     * Gets id of the conversation for which message was updated.
     *
     * @return Id of the updated message.
     */
    public String getConversationId() {
        return payload != null ? payload.conversationId : null;
    }

    /**
     * Gets profile id of the user that changed the message status.
     *
     * @return Profile id of the user that changed the message status.
     */
    public String getProfileId() {
        return payload != null ? payload.profileId : null;
    }

    /**
     * Gets time when the message status changed.
     *
     * @return Time when the message status changed.
     */
    public String getTimestamp() {
        return payload != null ? payload.timestamp : null;
    }

    @Override
    public String toString() {
        return super.toString()+
                " | conversationId = " + conversationEventId +
                " | profileId = " + getProfileId() +
                " | messageId = " + getMessageId();
    }
}