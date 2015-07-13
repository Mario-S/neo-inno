package org.inno.context;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.springframework.stereotype.Component;

/**
 * Glue to interact with all controllers.
 * @author spindizzy
 */
@Component
public class LookupAccess implements Lookup.Provider{
    
    private final Lookup lookup;
    private final InstanceContent content;
    
    public LookupAccess() {
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
