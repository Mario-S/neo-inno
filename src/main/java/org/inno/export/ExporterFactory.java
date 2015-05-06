package org.inno.export;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.inno.model.Node;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 * @author spindizzy
 */
public class ExporterFactory {
    
    public <T extends Node> Exportable<Collection<T>> createNodeExporter(Class<? extends Node> node){
        DefaultStrategy<T> strategy = new DefaultStrategy<>();
        return new NodeExporter<>(strategy);
    }
    
    public Exportable<Map<Project, Set<Technology>>> createRelationExporter() {
        DefaultStrategy<Entry<Project, Set<Technology>>> strategy = new DefaultStrategy <>();
        return new RelationExporter(strategy);
    }
}
