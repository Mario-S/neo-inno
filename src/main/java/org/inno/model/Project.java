package org.inno.model;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Model class for a project.
 * 
 * @author spindizzy
 */
@NodeEntity
public class Project extends Node{
    
    private final Set<Technology> technologies;
    
    public Project(){
        technologies = new HashSet<>();
    }
    
    public Project(String name, String version){
        this();
        setName(name);
        setVersion(version);
    }

    public boolean add(Technology e) {
        return technologies.add(e);
    }

    public void clear() {
        technologies.clear();
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }
    
}
