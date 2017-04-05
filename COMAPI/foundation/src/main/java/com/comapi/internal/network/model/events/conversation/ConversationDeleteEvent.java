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

package com.comapi.internal.network.model.events.conversation;

import com.google.gson.annotations.SerializedName;

/**
 * Event received trough socket. Conversation was deleted.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ConversationDeleteEvent extends ConversationEvent {

    public static final String TYPE = "conversation.delete";

    @SerializedName("payload")
    protected Payload payload;

    /**
     * Gets date when the conversation was deleted.
     *
     * @return Date when the conversation was deleted.
     */
    public String getDeletedOn() {
        return payload != null ? payload.date : null;
    }

    @Override
    public String toString() {
        return super.toString()+" | Conversation deleted on "+getDeletedOn();
    }

    private class Payload {

        @SerializedName("date")
        protected String date;
    }
}