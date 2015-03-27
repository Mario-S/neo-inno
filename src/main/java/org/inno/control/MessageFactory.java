package org.inno.control;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * @author spindizzy
 */
class MessageFactory {
    private final ResourceBundle bundle;

    MessageFactory(ResourceBundle bundle) {
        this.bundle = bundle;
    }
            
    String getMessage(String key, Object ... args){
        String msg;
        try{
            msg = bundle.getString(key);
            if(args != null && args.length > 0){
                msg = String.format(msg, args);
            }
        }catch(MissingResourceException exc){
            msg = key;
        }
        return msg;
    }
}
