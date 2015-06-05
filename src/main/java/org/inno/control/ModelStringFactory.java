package org.inno.control;

import static com.google.common.collect.Lists.newArrayList;
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

    String create() {
        builder.append(export(Technology.class));

        final Collection<? extends Project> projects = lookup(Project.class);
        builder.append(createExporter(Project.class).export(newArrayList(projects)));

        //TODO use project itself for relations 
        Map<Project, Set<Technology>> relations = new HashMap<>(projects.size());
        projects.forEach(p -> relations.put(p, p.getTechnologies()));
        builder.append(factory.createRelationExporter().export(relations));

        return builder.toString();
    }
    
    private String export(Class<? extends Node> clazz) {
        List<Node> nodes = newArrayList(lookup(clazz));
        return createExporter(clazz).export(nodes);
    }
    
    private Exportable<Collection<Node>> createExporter(Class<? extends Node> clazz){
        return factory.createNodeExporter(clazz);
    }

    private <T> Collection<? extends T> lookup(Class<T> clazz) {
        return lookup.lookupAll(clazz);
    }

}
