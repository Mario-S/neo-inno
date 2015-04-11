package org.inno.export;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
class RelationExporter implements Exportable<Map<Project,Set<Technology>>>{
    
    private Strategy<Entry<Project, Set<Technology>>> strategy;

    RelationExporter(Strategy<Entry<Project, Set<Technology>>> strategy) {
        this.strategy = strategy;
    }

    @Override
    public String export(Map<Project, Set<Technology>> type) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
