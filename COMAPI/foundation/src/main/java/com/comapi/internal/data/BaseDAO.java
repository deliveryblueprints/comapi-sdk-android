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

import java.util.Map;

/**
 * Base class for all Database Access Objects based on Android Shared Preferences.
 *
 * @author Marcin Swierczek
 * @since 1.0.0
 */
@SuppressWarnings("SameParameterValue")
class BaseDAO {

    private final SharedPreferences sharedPreferences;

    /**
     * Recommended constructor.
     *
     * @param context  Application context
     * @param fileName Shared context file name.
     */
    BaseDAO(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    /**
     * Saves Long value in internal shared preferences file.
     *
     * @param key   Key for shared preference entry.
     * @param value Value for shared preference entry.
     * @return Returns true if the new values were successfully written
     */
    boolean putInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * Saves String in internal shared preferences file.
     *
     * @param key   Key for internal preference entry.
     * @param value Value for internal preference entry.
     * @return Returns true if the new values were successfully written
     */
    boolean putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * Clear all entries in internal shared preferences file.
     *
     * @return Returns true if the new values were successfully written
     */
    boolean clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Map<String, ?> all = sharedPreferences.getAll();
        //noinspection Convert2streamapi
        for (String key : all.keySet()) {
            editor.remove(key);
        }
        return editor.commit();
    }

    /**
     * Clear entry.
     *
     * @param key Key for internal preference entry.
     * @return Returns true if the new values were successfully written
     */
    boolean clear(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        return editor.commit();
    }
}
