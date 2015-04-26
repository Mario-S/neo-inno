package org.inno.model;

/**
 * Model class for a project.
 * 
 * @author spindizzy
 */
public class Project extends Node{
    
    public Project(){
    }
    
    public Project(String name, String version){
        setName(name);
        setVersion(version);
    }
}
