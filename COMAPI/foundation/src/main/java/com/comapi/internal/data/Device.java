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

package com.comapi.internal.data;

/**
 * Represents cashed data context shared between user accounts.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class Device {

    private String apiSpaceId;

    private String instanceId;

    private int appVer;

    private String deviceId;

    private String pushToken;

    /**
     * Gets the App Space Id.
     *
     * @return App Space Id.
     */
    public String getApiSpaceId() {
        return apiSpaceId;
    }

    /**
     * Instance ID lets us delete and refresh tokens. Delegating instance id will invalidate all tokens,
     * including  FCM. We keep track over the id value to detect if FCM token was invalidated somewhere else in the app.
     *
     * @return Id of the InstanceId instance.
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Application version. Needed for refreshing token when application was updated.
     *
     * @return Version of the app as declared in Android Manifest.
     */
    public int getAppVer() {
        return appVer;
    }

    /**
     * Gets device unique id.
     *
     * @return Device unique id.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the App Space Id.
     *
     * @param apiSpaceId App Space Id.
     * @return {@link Device} instance with the new value.
     */
    public Device setApiSpaceId(String apiSpaceId) {
        this.apiSpaceId = apiSpaceId;
        return this;
    }

    /**
     * Instance ID lets us delete and refresh tokens. Delegating instance id will invalidate all tokens,
     * including  FCM. We keep track over the id value to detect if FCM token was invalidated somewhere else in the app.
     *
     * @param instanceId Id of the InstanceId instance.
     * @return {@link Device} instance with the new value.
     */
    Device setInstanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    /**
     * Sets Application version. Needed for refreshing token when application was updated.
     *
     * @param appVer Version of the app as declared in Android Manifest.
     * @return {@link Device} instance with the new value.
     */
    Device setAppVer(int appVer) {
        this.appVer = appVer;
        return this;
    }

    /**
     * Sets device unique id.
     *
     * @param deviceId Device unique id.
     * @return {@link Device} instance with the new value.
     */
    Device setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * Gets FCM token.
     *
     * @return FCM toke.
     */
    public String getPushToken() {
        return pushToken;
    }

    /**
     * Sets FCM registration token.
     *
     * @param pushToken FCM registration token.
     * @return {@link Device} instance with the new value.
     */
    Device setPushToken(String pushToken) {
        this.pushToken = pushToken;
        return this;
    }
}
