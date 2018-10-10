package com.comapi.internal.network.model.profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Wraps the raw map of profile properties into object with defaults, e.g. first name, last name etc. This properties cna be recognised e.g. by the Comapi Portal.
 *
 * @author Marcin Swierczek
 * @since 1.3.0
 */
public class ComapiProfile {

    private static final String keyId = "id";
    private static final String keyFirstName = "firstName";
    private static final String keyLastName = "lastName";
    private static final String keyEmail = "email";
    private static final String keyGender = "gender";
    private static final String keyPhoneNumber = "phoneNumber";
    private static final String keyCountryCode = "phoneNumberCountryCode";
    private static final String keyProfilePicture = "profilePicture";

    private Map<String, String> defaultProperties = new HashMap<>();

    private Map<String, Object> customProperties = new HashMap<>();

    public ComapiProfile() {
    }

    public ComapiProfile(Map<String, Object> properties) {

        if (properties != null && !properties.isEmpty()) {
            for (String key : properties.keySet()) {
                if (key.equals(keyId)) {
                    defaultProperties.put(key, (String) properties.get(key));
                }
                if (key.equals(keyFirstName)) {
                    setFirstName((String) properties.get(key));
                } else if (key.equals(keyLastName)) {
                    setLastName((String) properties.get(key));
                } else if (key.equals(keyEmail)) {
                    setEmail((String) properties.get(key));
                } else if (key.equals(keyPhoneNumber)) {
                    setPhoneNumber((String) properties.get(key));
                } else if (key.equals(keyCountryCode)) {
                    setPhoneNumberCountryCode((String) properties.get(key));
                } else if (key.equals(keyGender)) {
                    setGender((String) properties.get(key));
                } else if (key.equals(keyProfilePicture)) {
                    setProfilePicture((String) properties.get(key));
                } else if (!key.startsWith("_")) {
                    add(key, properties.get(key));
                }
            }
        }
    }

    /**
     * Internal profile id.
     */
    public String getId() {
        return defaultProperties.get(keyId);
    }

    public String getFirstName() {
        return defaultProperties.get(keyFirstName);
    }

    public ComapiProfile setFirstName(String value) {
        defaultProperties.put(keyFirstName, value);
        return this;
    }

    public String getLastName() {
        return defaultProperties.get(keyLastName);
    }

    public ComapiProfile setLastName(String value) {
        defaultProperties.put(keyLastName, value);
        return this;
    }

    public String getEmail() {
        return defaultProperties.get(keyEmail);
    }

    public ComapiProfile setEmail(String value) {
        defaultProperties.put(keyEmail, value);
        return this;
    }

    public String getGender() {
        return defaultProperties.get(keyGender);
    }

    public ComapiProfile setGender(String value) {
        defaultProperties.put(keyGender, value);
        return this;
    }

    public String getPhoneNumber() {
        return defaultProperties.get(keyPhoneNumber);
    }

    public ComapiProfile setPhoneNumber(String value) {
        defaultProperties.put(keyPhoneNumber, value);
        return this;
    }

    public String getPhoneNumberCountryCode() {
        return defaultProperties.get(keyCountryCode);
    }

    public ComapiProfile setPhoneNumberCountryCode(String value) {
        defaultProperties.put(keyCountryCode, value);
        return this;
    }

    public String getProfilePicture() {
        return defaultProperties.get(keyProfilePicture);
    }

    public ComapiProfile setProfilePicture(String value) {
        defaultProperties.put(keyProfilePicture, value);
        return this;
    }

    /**
     * Add custom key-value pair
     *
     * @param key   Profile property key
     *              avoid default keys : "id", "firstName", "lastName", "email", "gender", "phoneNumber", "phoneNumberCountryCode", "profilePicture";
     * @param value Profile property value.
     */
    public void add(String key, Object value) {
        customProperties.put(key, value);
    }

    /**
     * Remove custom key-value pair
     *
     * @param key   Profile property key
     *
     * @return Removed profile property value or null.
     */
    public Object remove(String key) {
        return customProperties.remove(key);
    }

    public Object get(String key) {
        return customProperties.get(key);
    }

    /**
     * Merge all profile properties to a single map.
     */
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.putAll(defaultProperties);
        map.putAll(customProperties);
        return map;
    }
}