package org.inno.model;

import static org.neo4j.graphdb.Direction.INCOMING;

import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.annotation.NodeEntity;


/**
 * Model class for a project.
 *
 * @author spindizzy
 */
public class Project extends Node {
    @RelatedTo(type = "USES", direction = INCOMING)
    private final Set<Technology> technologies;

    public Project() {
        technologies = new HashSet<>();
    }

    public Project(final String name, final String version) {
        this();
        setName(name);
        setVersion(version);
    }

    public boolean add(final Technology e) {
        return technologies.add(e);
    }

    public void clear() {
        technologies.clear();
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }
}
