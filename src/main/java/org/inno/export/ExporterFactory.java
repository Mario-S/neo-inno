package org.inno.export;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.inno.model.Node;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 * @author spindizzy
 */
public class ExporterFactory {
    
    public <T extends Node> Exportable<Collection<T>> createExporter(Class<? extends Node> node){
        AbstractStrategy strategy;
        if(node.getClass().equals(Technology.class)){
            strategy = new TechnologyStrategy();
        }else{
            strategy = new ProjectStrategy();
        }
        return new NodeExporter<>(strategy);
    }
    
    public Exportable<Map<Project, Set<Technology>>> createRelationExporter() {
        RelationStrategy strategy = new RelationStrategy();
        return new RelationExporter(strategy);
    }
}
