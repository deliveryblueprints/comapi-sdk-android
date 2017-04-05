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
 * Wrapper for various push configurations.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class PushPlatforms {

    @SerializedName("apns")
    private Map<String, Object> apns;

    @SerializedName("fcm")
    private Map<String, Object> fcm;

    /**
     * Gets definition of APNS notification
     *
     * @return Definition of APNS notification
     */
    public Map<String, Object> getApns() {
        return apns;
    }

    /**
     * Gets definition of FCM notification
     *
     * @return Definition of FCM notification
     */
    public Map<String, Object> getFcm() {
        return fcm;
    }

    /**
     * Set definition of APNS notification
     *
     * @param apns Definition of APNS notification
     */
    void setApns(Map<String, Object> apns) {
        this.apns = apns;
    }

    /**
     * Set definition of FCM notification
     *
     * @param fcm Definition of APNS notification
     */
    void setFcm(Map<String, Object> fcm) {
        this.fcm = fcm;
    }
}
