package org.inno.export;

import java.util.List;
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
    public String export(List<Technology> type) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
