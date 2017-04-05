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

import com.comapi.internal.network.model.conversation.ConversationBase;
import com.google.gson.annotations.SerializedName;

import com.comapi.internal.network.model.conversation.Roles;

/**
 * Event received trough socket. Conversation was updated.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ConversationUpdateEvent extends ConversationEvent {

    public static final String TYPE = "conversation.update";

    @SerializedName("payload")
    protected ConversationBase payload;

    /**
     * Get name of the Conversation.
     *
     * @return Name of the Conversation.
     */
    public String getConversationName() {
        return payload != null ? payload.getName() : null;
    }

    /**
     * Get ID of the Conversation.
     *
     * @return ID of the Conversation.
     */
    public String getDescription() {
        return payload != null ? payload.getDescription() : null;
    }

    /**
     * Get description of the Conversation.
     *
     * @return Description of the Conversation.
     */
    public Roles getRoles() {
        return payload != null ? payload.getRoles() : null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}