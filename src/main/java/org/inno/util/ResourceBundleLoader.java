package org.inno.util;

import java.util.ResourceBundle;

/**
 *
 * @author spindizzy
 */
public enum ResourceBundleLoader {
    Instance;
    
    private MessageFactory factory;
    
    private ResourceBundle bundle;
    
    private ResourceBundleLoader(){
        bundle = ResourceBundle.getBundle("org.inno.bundles.bundle");
        factory = new MessageFactory(bundle);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public MessageFactory getFactory() {
        return factory;
    }
}
