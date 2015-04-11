package org.inno.export;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 * @author spindizzy
 */
public class ExporterFactory {
    public Exportable<Collection<Project>> createProjectExporter() {
        CypherProjectStrategy strategy = new CypherProjectStrategy();
        return new ProjectNodeExporter(strategy);
    }
    
    public Exportable<Collection<Technology>> createTechnologyExporter() {
        CypherTechnologyStrategy strategy = new CypherTechnologyStrategy();
        return new TechnologyNodeExporter(strategy);
    }
    
    public Exportable<Map<Project, Set<Technology>>> createRelationExporter() {
        CypherRelationStrategy strategy = new CypherRelationStrategy();
        return new RelationExporter(strategy);
    }
}
