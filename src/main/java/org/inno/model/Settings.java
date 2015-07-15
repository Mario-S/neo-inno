/*
 * Created by Schuetze Consulting Informationssysteme AG, Berlin.
 */
package org.inno.model;

import org.springframework.stereotype.Component;

import org.springframework.util.StringUtils;

import java.util.prefs.Preferences;


/**
 * @author spindizzy
 */
@Component
public class Settings {
    private static final String KEY = "org.inno.rest.url";

    /** default REST service URL.* */
    public static final String DEFAULT_URL = "http://localhost:7474/db/data/";

    public String getRestUrl() {
        return Preferences.userRoot().get(KEY, DEFAULT_URL);
    }

    public void setRestUrl(final String url) {
        if (StringUtils.hasText(url) && !url.equalsIgnoreCase(DEFAULT_URL)) {
            Preferences.userRoot().put(KEY, url);
        }
    }
}
