package org.inno.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;


/**
 * Model class for a technology.
 *
 * @author spindizzy
 */
public class Technology extends Node {
    private final StringProperty layer = new SimpleStringProperty();
    private final ObjectProperty<State> status = new SimpleObjectProperty<>();
    private final StringProperty groupId = new SimpleStringProperty();
    private final StringProperty artifactId = new SimpleStringProperty();

    public String getLayer() {
        return layer.get();
    }

    public State getStatus() {
        return status.get();
    }

    public String getGroupId() {
        return groupId.get();
    }

    public String getArtifactId() {
        return artifactId.get();
    }

    public void setLayer(final String layer) {
        this.layer.set(layer);
    }

    public void setStatus(final State status) {
        this.status.set(status);
    }

    public void setGroupId(final String groupId) {
        this.groupId.set(groupId);
    }

    public void setArtifactId(final String artifactId) {
        this.artifactId.set(artifactId);
    }

    public StringProperty layerProperty() {
        return layer;
    }

    public ObjectProperty<State> statusProperty() {
        return status;
    }

    public StringProperty groupIdProperty() {
        return groupId;
    }

    public StringProperty artifacIdProperty() {
        return artifactId;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = (29 * hash) + Objects.hashCode(getLayer());
        hash = (29 * hash) + Objects.hashCode(getStatus());
        hash = (29 * hash) + Objects.hashCode(getGroupId());
        hash = (29 * hash) + Objects.hashCode(getArtifactId());

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

        final Technology other = (Technology) obj;

        if (!hasEqualFields(other)) {
            return false;
        }

        if (!Objects.equals(this.getLayer(), other.getLayer())) {
            return false;
        }

        if (!Objects.equals(this.getStatus(), other.getStatus())) {
            return false;
        }

        if (!Objects.equals(this.getGroupId(), other.getGroupId())) {
            return false;
        }

        if (!Objects.equals(this.getArtifactId(), other.getArtifactId())) {
            return false;
        }

        return true;
    }
}
