package org.inno.control;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author spindizzy
 */
final class MessageFactory {
    private final ResourceBundle bundle;

    MessageFactory(final ResourceBundle bundle) {
        this.bundle = bundle;
    }

    String getMessage(final String key) {
        return getMessage(key, new Object());
    }

    String getMessage(final String key, final Object... args) {
        String msg;

        try {
            msg = bundle.getString(key);

            if ((args != null) && (args.length > 0)) {
                msg = String.format(msg, args);
            }
        } catch (MissingResourceException exc) {
            msg = key;
        }

        return msg;
    }
}
