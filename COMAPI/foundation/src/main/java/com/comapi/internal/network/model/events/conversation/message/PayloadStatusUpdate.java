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
 * Payload of the message status update socket event.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
class PayloadStatusUpdate {

    @SerializedName("messageId")
    protected String messageId;

    @SerializedName("conversationId")
    protected String conversationId;

    @SerializedName("profileId")
    protected String profileId;

    @SerializedName("timestamp")
    protected String timestamp;

    /**
     * Message unique identifier
     *
     * @return Message unique identifier
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Gets conversation id for which the message status was updated.
     *
     * @return Conversation id for which the message status was updated.
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Gets profile id of the user that updated the message status.
     *
     * @return Profile id of the user that updated the message status.
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Gets time when the message status was updated.
     *
     * @return Time when the message status was updated.
     */
    public String getTimestamp() {
        return timestamp;
    }
}
