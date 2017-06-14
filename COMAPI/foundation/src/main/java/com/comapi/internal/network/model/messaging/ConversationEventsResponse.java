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

import com.comapi.internal.Parser;
import com.comapi.internal.network.model.events.Event;
import com.comapi.internal.network.model.events.conversation.message.MessageDeliveredEvent;
import com.comapi.internal.network.model.events.conversation.message.MessageReadEvent;
import com.comapi.internal.network.model.events.conversation.message.MessageSentEvent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * Response of an events query for a conversation. Replaces {@link EventsQueryResponse}
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ConversationEventsResponse {

    private final List<MessageSentEvent> messageSent = new ArrayList<>();

    private final List<MessageDeliveredEvent> messageDelivered = new ArrayList<>();

    private final List<MessageReadEvent> messageRead = new ArrayList<>();

    private final TreeMap<Integer, Event> map = new TreeMap<>();

    public ConversationEventsResponse(List<JsonObject> newEvents, Parser parser) {

        if (newEvents != null) {
            int count = 0;
            for (JsonObject event : newEvents) {
                parseEvent(event, parser, count++);
            }
        }
    }

    /**
     * Parse event and add to appropriate list.
     *
     * @param event  Json object to parse.
     * @param parser Parser interface.
     * @param i      Number of event in the json array.
     */
    private void parseEvent(JsonObject event, Parser parser, int i) {

        JsonElement nameJE = event.get(Event.KEY_NAME);

        if (nameJE != null) {

            String name = nameJE.getAsString();

            if (MessageSentEvent.TYPE.equals(name)) {
                MessageSentEvent parsed = parser.parse(event, MessageSentEvent.class);
                messageSent.add(parsed);
                map.put(i, parsed);
            } else if (MessageDeliveredEvent.TYPE.equals(name)) {
                MessageDeliveredEvent parsed = parser.parse(event, MessageDeliveredEvent.class);
                messageDelivered.add(parsed);
                map.put(i, parsed);
            } else if (MessageReadEvent.TYPE.equals(name)) {
                MessageReadEvent parsed = parser.parse(event, MessageReadEvent.class);
                messageRead.add(parsed);
                map.put(i, parsed);
            }
        }
    }

    /**
     * Gets Events in the order in which they were received. This collection can contain following conversation events:
     * {@link MessageSentEvent} - new message received in the conversation
     * {@link MessageDeliveredEvent} - message status marked 'delivered'
     * {@link MessageReadEvent} - message status marked 'read'
     * Cast elements of this collection to one of these.
     *
     * @return Collection of events received from event query.
     */
    public Collection<Event> getEventsInOrder() {
        return map.values();
    }

    /**
     * Get list of parsed {@link MessageSentEvent}'s - new message received in the conversation.
     *
     * @return List of received {@link MessageSentEvent}'s.
     */
    public List<MessageSentEvent> getMessageSent() {
        return messageSent;
    }

    /**
     * Get list of parsed {@link MessageDeliveredEvent}'s - message status marked 'delivered'.
     *
     * @return List of received {@link MessageDeliveredEvent}'s.
     */
    public List<MessageDeliveredEvent> getMessageDelivered() {
        return messageDelivered;
    }

    /**
     * Get list of parsed {@link MessageReadEvent}'s - message status marked 'read'.
     *
     * @return List of received {@link MessageReadEvent}'s.
     */
    public List<MessageReadEvent> getMessageRead() {
        return messageRead;
    }
}