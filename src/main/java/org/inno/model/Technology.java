package org.inno.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a technology.
 *
 * @author spindizzy
 */
public class Technology extends Node{

    private final StringProperty layer = new SimpleStringProperty();
    private final ObjectProperty<State> status = new SimpleObjectProperty<>(State.Red);
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


    public void setLayer(String layer) {
        this.layer.set(layer);
    }

    public void setStatus(State status) {
        this.status.set(status);
    }

    public void setGroupId(String groupId) {
        this.groupId.set(groupId);
    }

    public void setArtifactId(String artifactId) {
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

}
