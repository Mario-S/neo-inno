package de.scag.inno.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a technology.
 *
 * @author spindizzy
 */
public class Technology {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty version = new SimpleStringProperty();
    private final StringProperty layer = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty groupId = new SimpleStringProperty();
    private final StringProperty artifactId = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public String getVersion() {
        return version.get();
    }

    public String getLayer() {
        return layer.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getGroupId() {
        return groupId.get();
    }

    public String getArtifactId() {
        return artifactId.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setVersion(String version) {
        this.version.set(version);
    }

    public void setLayer(String layer) {
        this.layer.set(layer);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setGroupId(String groupId) {
        this.groupId.set(groupId);
    }

    public void setArtifactId(String artifactId) {
        this.artifactId.set(artifactId);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty versionProperty() {
        return version;
    }

    public StringProperty layerProperty() {
        return layer;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty groupIdProperty() {
        return groupId;
    }

    public StringProperty artifacIdProperty() {
        return artifactId;
    }

}
