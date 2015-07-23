package org.inno.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.springframework.data.neo4j.annotation.GraphId;

import java.util.Objects;


/**
 * Parent class which identifies a node.
 *
 * @author spindizzy
 */
public class Node {
    @GraphId
    private Long id;

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

    public void setName(final String name) {
        this.name.set(name);
    }

    public void setVersion(final String version) {
        this.version.set(version);
    }

    public StringProperty versionProperty() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (53 * hash) + Objects.hashCode(this.getId());
        hash = (53 * hash) + Objects.hashCode(this.getName());
        hash = (53 * hash) + Objects.hashCode(this.getVersion());

        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Node other = (Node) obj;

        if (!hasEqualFields(other)) {
            return false;
        }

        return true;
    }

    boolean hasEqualFields(final Node other) {
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        if (!Objects.equals(this.getName(), other.getName())) {
            return false;
        }

        if (!Objects.equals(this.getVersion(), other.getVersion())) {
            return false;
        }

        return true;
    }
}
