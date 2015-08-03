package org.inno.context;

import org.springframework.util.StringUtils;

import java.util.prefs.Preferences;


/**
 * Application Settings.
 *
 * @author spindizzy
 */
public enum Settings {
    Instance;

    private static final String KEY = "org.inno.rest.url";

    /** default REST service URL.* */
    public static final String DEFAULT_URL = "http://localhost:7474/db/data/";

    public String getRestUrl() {
        return Preferences.userRoot().get(KEY, DEFAULT_URL);
    }

    public void setRestUrl(final String url) {
        if (StringUtils.hasText(url)) {
            Preferences.userRoot().put(KEY, url);
        }
    }
}
