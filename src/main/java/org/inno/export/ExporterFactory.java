package org.inno.export;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 * @author spindizzy
 */
public class ExporterFactory {
    public Exportable<List<Project>> createProjectExporter() {
        CypherProjectStrategy strategy = new CypherProjectStrategy();
        return new ProjectNodeExporter(strategy);
    }
    
    public Exportable<List<Technology>> createTechnology() {
        CypherTechnologyStrategy strategy = new CypherTechnologyStrategy();
        return new TechnologyNodeExporter(strategy);
    }
    
    
    public Exportable<Map<Project, Set<Technology>>> createRelationExporter() {
        CypherRelationStrategy strategy = new CypherRelationStrategy();
        return new RelationExporter(strategy);
    }
}
