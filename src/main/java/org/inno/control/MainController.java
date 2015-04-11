package org.inno.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import javafx.stage.FileChooser;

import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.inno.export.ExporterFactory;
import org.inno.model.Project;
import org.inno.model.Technology;
import org.openide.util.Lookup;

/**
 * Controller to create the CYPHER statements.
 *
 * @author spindizzy
 */
public class MainController extends AbstractController implements LookupListener {

    private final BooleanProperty disableProperty;

    private final Result<org.inno.model.Node> result;

    @FXML
    private TextField txtFile;

    @FXML
    private Button btnCreate;

    @FXML
    private Tab relationTab;

    private File exportFile;

    public MainController() {
        disableProperty = new SimpleBooleanProperty(true);
        result = getContext().getLookup().lookupResult(org.inno.model.Node.class);
        result.addLookupListener(this);
    }

    @Override
    void initialize(final MessageFactory factory) {
        btnCreate.disableProperty().bind(disableProperty);
        relationTab.disableProperty().bind(disableProperty);
    }

    @FXML
    protected void handleFileSelection(final ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Output File");

        Node node = (Node) event.getSource();
        exportFile = fileChooser.showOpenDialog(node.getScene().getWindow());

        if (exportFile != null) {
            txtFile.setText(exportFile.getPath());
            resultChanged(null);
        }
    }

    @Override
    public void resultChanged(final LookupEvent le) {
        Collection<?> nodes = result.allInstances();
        disableProperty.set(exportFile == null || nodes.isEmpty());
    }

    @FXML
    void export(final ActionEvent event) {
        if (exportFile != null) {
            try {
                FileWriter writer = new FileWriter(exportFile);
                writer.write(createExportString());
            } catch (IOException exc) {
                getLogger().warn(exc.getMessage(), exc);
            }
        }
    }

    private String createExportString() {
        Lookup lookup = getContext().getLookup();
        Collection<? extends Project> projects = lookup.lookupAll(Project.class);
        Collection<? extends Technology> technologies = lookup.lookupAll(Technology.class);
        Collection<? extends Map<Project, Set<Technology>>> relations = lookup.lookupAll(HashMap.class);
        ExporterFactory factory = new ExporterFactory();
        StringBuilder builder = new StringBuilder();
        builder.append(factory.createProjectExporter().export((Collection<Project>) projects));
        builder.append(factory.createTechnologyExporter().export((Collection<Technology>) technologies));
        builder.append(factory.createRelationExporter().export((Map<Project, Set<Technology>>) relations));
        return builder.toString();
    }
}
