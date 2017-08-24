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

import com.google.gson.annotations.SerializedName;

/**
 * Role that can be assign to a conversation participant.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class Role {

    @SerializedName("canSend")
    private Boolean canSend;

    @SerializedName("canAddParticipants")
    private Boolean canAddParticipants;

    @SerializedName("canRemoveParticipants")
    private Boolean canRemoveParticipants;

    /**
     * Recommended constructor. By default Participant can send messages, can add participants, cannot remove participants.
     */
    public Role() {
        this.canSend = true;
        this.canAddParticipants = true;
        this.canRemoveParticipants = false;
    }

    /**
     * Check if participant with this role can send messages to the conversation.
     *
     * @return True if participant with this role can send messages to the conversation.
     */
    public Boolean getCanSend() {
        return canSend;
    }

    /**
     * Check if participant with this role can add participants to the conversation.
     *
     * @return True if participant with this role can add participants to the conversation.
     */
    public Boolean getCanAddParticipants() {
        return canAddParticipants;
    }

    /**
     * Check if participant with this role can remove participants from the conversation.
     *
     * @return True if participant with this role can remove participants from the conversation.
     */
    public Boolean getCanRemoveParticipants() {
        return canRemoveParticipants;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        Role role;

        Builder() {
            role = new Role();
        }

        public Role build() {
            return role;
        }

        /**
         * Participant with this role will be able to send messages to the conversation.
         *
         * @return Instance of the role that allows sending messages to the conversation.
         */
        public Builder setCanSend() {
            role.canSend = true;
            return this;
        }

        /**
         * Participant with this role will be able to add participants to the conversation.
         *
         * @return Instance of the role that allows adding participants to the conversation.
         */
        public Builder setCanAddParticipants() {
            role.canAddParticipants = true;
            return this;
        }

        /**
         * Participant with this role will be able to remove participants from the conversation.
         *
         * @return Instance of the role that allows removing participants from the conversation.
         */
        public Builder setCanRemoveParticipants() {
            role.canRemoveParticipants = true;
            return this;
        }

        /**
         * Participant with this role will be able to send messages to the conversation.
         *
         * @param canSend Will be able to send messages if true.
         * @return Instance of the role that allows sending messages to the conversation.
         */
        public Builder setCanSend(boolean canSend) {
            role.canSend = canSend;
            return this;
        }

        /**
         * Participant with this role will be able to add participants to the conversation.
         *
         * @param canAddParticipants Will be able to add participants if true.
         * @return Instance of the role that allows adding participants to the conversation.
         */
        public Builder setCanAddParticipants(boolean canAddParticipants) {
            role.canAddParticipants = canAddParticipants;
            return this;
        }

        /**
         * Participant with this role will be able to remove participants from the conversation.
         *
         * @param canRemoveParticipants Will be able to remove participants if true.
         * @return Instance of the role that allows removing participants from the conversation.
         */
        public Builder setCanRemoveParticipants(boolean canRemoveParticipants) {
            role.canRemoveParticipants = canRemoveParticipants;
            return this;
        }
    }
}
