package org.inno.context;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * Glue to interact with all controllers.
 * @author spindizzy
 */
public enum Context implements Lookup.Provider{
    Instance;
    
    private final Lookup lookup;
    private final InstanceContent content;
    
    private Context() {
        content = new InstanceContent();
        lookup = new AbstractLookup(content);
    }

    @Override
    public Lookup getLookup() {
        return lookup;
    }

    public InstanceContent getContent() {
        return content;
    }
}
