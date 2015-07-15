package org.inno.control;

import static com.google.common.collect.Lists.newArrayList;

import org.inno.export.ExporterFactory;

import org.inno.model.Node;
import org.inno.model.Project;
import org.inno.model.Technology;

import org.openide.util.Lookup;

import java.util.Collection;
import java.util.List;


/**
 * Constrcuts a String which contains a Cypher Statement based on the nodes and
 * their relations.
 *
 * @author spindizzy
 */
class ModelStringFactory {
    private final Lookup lookup;
    private final ExporterFactory factory;
    private final StringBuilder builder;

    ModelStringFactory(final Lookup lookup) {
        this.lookup = lookup;
        this.factory = new ExporterFactory();
        this.builder = new StringBuilder();
    }

    String create() {
        builder.append(export(Technology.class)).append(export(Project.class));

        return builder.toString();
    }

    private String export(final Class<? extends Node> clazz) {
        List<Node> nodes = newArrayList(lookup(clazz));

        return factory.createNodeExporter().export(nodes);
    }

    private <T> Collection<? extends T> lookup(final Class<T> clazz) {
        return lookup.lookupAll(clazz);
    }
}
