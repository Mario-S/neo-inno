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
        ProjectStrategy strategy = new ProjectStrategy();
        return new NodeExporter(strategy);
    }
    
    public Exportable<Collection<Technology>> createTechnologyExporter() {
        TechnologyStrategy strategy = new TechnologyStrategy();
        return new NodeExporter(strategy);
    }
    
    public Exportable<Map<Project, Set<Technology>>> createRelationExporter() {
        RelationStrategy strategy = new RelationStrategy();
        return new RelationExporter(strategy);
    }
}
