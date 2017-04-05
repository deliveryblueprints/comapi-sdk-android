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

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Database Access Object for Device/Application related data.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class DeviceDAO extends BaseDAO {

    private static final String fileNamePrefix = "device.";

    private static final String KEY_INSTANCE_ID = "iId";

    private static final String KEY_APP_VER = "aV";

    private static final String KEY_DEVICE_ID = "dId";

    private static final String KEY_API_SPACE_ID = "aS";

    private static final String KEY_PUSH_TOKEN = "pT";

    /**
     * Recommended constructor.
     *
     * @param context Application context.
     */
    DeviceDAO(final Context context, final String suffix) {
        super(context, fileNamePrefix+suffix);
    }

    /**
     * Loads device details from internal storage.
     *
     * @return Loaded device details.
     */
    private Device loadDevice() {
        //Initialise object with the content saved in shared pref file.
        SharedPreferences sharedPreferences = getSharedPreferences();
        return new Device()
                .setApiSpaceId(sharedPreferences.getString(KEY_API_SPACE_ID, null))
                .setAppVer(sharedPreferences.getInt(KEY_APP_VER, -1))
                .setInstanceId(sharedPreferences.getString(KEY_INSTANCE_ID, null))
                .setPushToken(sharedPreferences.getString(KEY_PUSH_TOKEN, null))
                .setDeviceId(sharedPreferences.getString(KEY_DEVICE_ID, null));
    }

    /**
     * Gets device/application related data.
     *
     * @return Device/application related data.
     */
    public Device device() {
        return loadDevice();
    }

    /**
     * Sets InstanceId id. Used to check if FCM token needs to be refreshed.
     *
     * @param instanceId Android InstanceId id.
     * @return True if value was set successfully.
     */
    synchronized boolean setInstanceId(String instanceId) {
        return putString(KEY_INSTANCE_ID, instanceId);
    }

    /**
     * Sets the Application version number as defined in Android Manifest.
     *
     * @param appVer Application version number.
     * @return True if value was set successfully.
     */
    synchronized boolean setAppVer(int appVer) {
        return putInt(KEY_APP_VER, appVer);
    }

    /**
     * Sets the unique identifier generated for the device.
     *
     * @param devId Unique identifier generated for the device.
     * @return True if value was set successfully.
     */
    synchronized boolean setDeviceId(String devId) {
        return putString(KEY_DEVICE_ID, devId);
    }

    /**
     * Sets App Space id.
     *
     * @param apiSpaceId App Space id.
     * @return True if value was set successfully.
     */
    public synchronized boolean setApiSpaceId(String apiSpaceId) {
        return putString(KEY_API_SPACE_ID, apiSpaceId);
    }

    /**
     * Sets Push Token.
     *
     * @param token Push Token.
     * @return True if value was set successfully.
     */
    public synchronized boolean setPushToken(String token) {
        return putString(KEY_PUSH_TOKEN, token);
    }
}