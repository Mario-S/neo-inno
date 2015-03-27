package org.inno.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Parent class which identifies a node
 * @author spindizzy
 */
public class Node {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty version = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public String getVersion() {
        return version.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setVersion(String version) {
        this.version.set(version);
    }

    public StringProperty versionProperty() {
        return version;
    }
    
}
