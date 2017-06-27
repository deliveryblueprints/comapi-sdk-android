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

package com.comapi.internal.network.model.events;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Event received trough socket.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class ProfileUpdateEvent extends Event {

    public static final String TYPE = "profile.update";

    @SerializedName("profileId")
    protected String profileId;

    @SerializedName("publishedOn")
    protected String publishedOn;

    @SerializedName("revision")
    protected int revision;

    @SerializedName("context")
    protected ProfileContext context;

    @SerializedName("payload")
    protected Map<String, Object> payload;

    @SerializedName("apiSpaceId")
    protected String apiSpaceId;

    @SerializedName("etag")
    protected String eTag;

    /**
     * Gets id for a Comapi user profile that was updated.
     *
     * @return Gets id for a Comapi user profile that was updated.
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * Gets time when the update event was published.
     *
     * @return Time when the update event was published.
     */
    public String getPublishedOn() {
        return publishedOn;
    }

    /**
     * Gets revision of the profile details on the server.
     *
     * @return Revision of the profile details on the server.
     */
    public int getRevision() {
        return revision;
    }

    /**
     * Gets profileId of an user that performed this update.
     *
     * @return ProfileId of an user that performed this update.
     */
    public String getCreatedBy() {
        return context != null ? context.createdBy : null;
    }

    /**
     * Gets profile update details.
     *
     * @return Profile update details.
     */
    public Map<String, Object> getPayload() {
        return payload;
    }

    /**
     * Gets API Space in which profile exist.
     *
     * @return API Space in which profile exist.
     */
    public String getApiSpaceId() {
        return apiSpaceId;
    }

    /**
     * Gets tag specifying server data version.
     *
     * @return Tag specifying server data version.
     */
    public String getETag() {
        return eTag;
    }

    private class ProfileContext {

        @SerializedName("createdBy")
        protected String createdBy;

    }

    @Override
    public String toString() {
        return super.toString() +
                " | profile " + profileId +
                " | updated on " + publishedOn +
                " | created by = " + getCreatedBy();
    }
}