package org.inno.export;

import java.util.Map;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
public class RelationExporter implements Exporter<Map<Project,Set<Technology>>>{

    @Override
    public String export(Map<Project, Set<Technology>> type) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
