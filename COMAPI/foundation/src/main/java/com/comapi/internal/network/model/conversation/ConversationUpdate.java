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

package com.comapi.internal.network.model.conversation;

import android.text.TextUtils;

import java.util.UUID;

/**
 * Conversation details to update.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ConversationUpdate extends ConversationBase {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        ConversationUpdate conversation;

        public Builder() {
            conversation = new ConversationUpdate();
        }

        /**
         * Set name for the Conversation.
         *
         * @param name Conversation name.
         * @return Instance with new name.
         */
        public Builder setName(String name) {
            conversation.name = name;
            return this;
        }

        /**
         * Set description for the Conversation.
         *
         * @param description Conversation description.
         * @return Instance with new description.
         */
        public Builder setDescription(String description) {
            conversation.description = description;
            return this;
        }

        /**
         * Set participant role definitions for the Conversation.
         *
         * @param roles Participant roles.
         * @return Instance with new participant roles.
         */
        public Builder setRoles(Roles roles) {
            conversation.roles = roles;
            return this;
        }

        /**
         * Set public access to the Conversation.
         *
         * @param isPublic True if Conversation is publicly accessible.
         * @return Instance with new value set.
         */
        public Builder setPublic(Boolean isPublic) {
            conversation.isPublic = isPublic;
            return this;
        }

        public ConversationUpdate build() {

            if (TextUtils.isEmpty(conversation.name)) {
                conversation.name = UUID.randomUUID().toString();
            }
            if (conversation.isPublic == null) {
                conversation.isPublic = false;
            }
            if (conversation.roles == null) {
                conversation.roles = new Roles(new Role(), new Role());
            } else {
                if (conversation.roles.getOwner() == null) {
                    conversation.roles.owner = new Role();
                }
                if (conversation.roles.getParticipant() == null) {
                    conversation.roles.participant = new Role();
                }
            }

            return conversation;
        }
    }
}
