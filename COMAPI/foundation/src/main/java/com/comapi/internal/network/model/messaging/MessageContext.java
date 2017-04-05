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
 * Context of received message.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class MessageContext {

    @SerializedName("from")
    private Sender fromWhom;

    @SerializedName("sentBy")
    private String sentBy;

    @SerializedName("sentOn")
    private String sentOn;

    @SerializedName("conversationId")
    private String conversationId;

    /**
     * Message sender
     *
     * @return Message sender
     */
    public Sender getFromWhom() {
        return fromWhom;
    }

    /**
     * Message sender defined internally on server (shouldn't be visible inside the app)
     *
     * @return Message sender defined internally on server (shouldn't be visible inside the app)
     */
    public String getSentBy() {
        return sentBy;
    }

    /**
     * When the message was sent
     *
     * @return When the message was sent
     */
    public String getSentOn() {
        return sentOn;
    }

    /**
     * Conversation unique identifier
     *
     * @return Conversation unique identifier
     */
    public String getConversationId() {
        return conversationId;
    }
}
