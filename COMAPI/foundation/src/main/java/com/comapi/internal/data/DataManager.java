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
import android.text.TextUtils;

import com.comapi.internal.log.Logger;
import com.google.firebase.iid.FirebaseInstanceId;

import com.comapi.internal.helpers.DeviceHelper;

/**
 * Manager class for internal data storage.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
public class DataManager {

    private DeviceDAO deviceDAO;

    private SessionDAO sessionDAO;

    private Logger log;

    /**
     * Initialise Session Manager.
     *
     * @param context Application context.
     * @param logger  Logger instance for logging output.
     */
    public void init(final Context context, final String suffix, final Logger logger) {
        log = logger;
        deviceDAO = new DeviceDAO(context, suffix);
        onetimeDeviceSetup(context);
        sessionDAO = new SessionDAO(context, suffix);
    }

    /**
     * Gets the application/device data access object.
     *
     * @return Application/device data.
     */
    public DeviceDAO getDeviceDAO() {
        return deviceDAO;
    }

    /**
     * Gets the session data access object.
     *
     * @return session data.
     */
    public SessionDAO getSessionDAO() {
        return sessionDAO;
    }

    /**
     * Populates basic application/device data if app is running for the first time.
     */
    private void onetimeDeviceSetup(Context context) {
        if (TextUtils.isEmpty(deviceDAO.device().getDeviceId())) {
            deviceDAO.setDeviceId(DeviceHelper.generateDeviceId(context));
            log.d("Comapi generated unique device id = " + deviceDAO.device().getDeviceId());
            try {
                deviceDAO.setInstanceId(FirebaseInstanceId.getInstance().getId());
            } catch (IllegalStateException e) {
                deviceDAO.setInstanceId("empty");
            }
            log.d("Comapi detected application instance id = " + deviceDAO.device().getInstanceId());
            deviceDAO.setAppVer(DeviceHelper.getAppVersion(context));
            log.d("Comapi detected app version = " + deviceDAO.device().getAppVer());
        }
    }
}
