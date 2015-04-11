package org.inno.export;

import java.util.Collection;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
class TechnologyNodeExporter extends AbstractNodeExporter<Technology>{

    TechnologyNodeExporter(Strategy<Technology> strategy) {
        super(strategy);
    }

    @Override
    public String export(Collection<Technology> type) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
