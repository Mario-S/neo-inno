package org.inno.control;

import static com.google.common.collect.Lists.newArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.inno.export.Exportable;
import org.inno.export.ExporterFactory;
import org.inno.model.Node;
import org.inno.model.Project;
import org.inno.model.Technology;
import org.openide.util.Lookup;

/**
 *
 * @author spindizzy
 */
class ModelStringFactory {

    private final Lookup lookup;
    private final ExporterFactory factory;
    private final StringBuilder builder;

    ModelStringFactory(Lookup lookup) {
        this.lookup = lookup;
        this.factory = new ExporterFactory();
        this.builder = new StringBuilder();
    }
    
    String create(){
        Exportable<Collection<Node>> exporter = factory.createNodeExporter(Project.class);
        List<Node> projects = newArrayList(lookup(Project.class));
        builder.append(exporter.export(projects));
        
        exporter = factory.createNodeExporter(Technology.class);
        List<Node> technologies = newArrayList(lookup(Technology.class));
        builder.append(exporter.export(technologies));
        
        Map<Project, Set<Technology>> relations = lookup.lookup(Map.class);
        builder.append(factory.createRelationExporter().export(relations));
        
        return builder.toString();
    }


    private <T> Collection<? extends T> lookup(Class<T> clazz) {
        return lookup.lookupAll(clazz);
    }

}
