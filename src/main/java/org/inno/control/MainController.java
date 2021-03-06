package org.inno.control;

import org.inno.context.Settings;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import org.inno.dao.ProjectRepository;
import org.inno.dao.TechnologyRepository;
import org.inno.model.Project;
import org.inno.model.Technology;
import org.openide.util.Lookup;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controller to create the CYPHER nodes.
 *
 * @author spindizzy
 */
@Component
public class MainController extends AbstractController implements LookupListener {

    private final BooleanProperty disableExportProperty;

    private final BooleanProperty disableRelationProperty;

    private final BooleanProperty busyProperty;

    private Result<org.inno.model.Node> result;

    @FXML
    private TextField txtFile;

    @FXML
    private Button btnExport;
    
    @FXML
    private Button btnSave;

    @FXML
    private Tab relationTab;

    @FXML
    private Node glassPane;

    private File exportFile;

    private DialogFactory dialogFactory;

    private final Settings settings;
    
    @Autowired
    private TechnologyRepository technologyRepository;
    
    @Autowired
    private ProjectRepository projectRepository;

    public MainController() {
        disableExportProperty = new SimpleBooleanProperty(true);
        disableRelationProperty = new SimpleBooleanProperty(true);
        busyProperty = new SimpleBooleanProperty(false);
        settings = Settings.Instance;
    }

    @Override
    protected void afterPropertiesSet() {
        result = getLookupProvider().getLookup().lookupResult(org.inno.model.Node.class);
        result.addLookupListener(this);
    }

    @Override
    void initialize(final MessageFactory factory) {
        dialogFactory = new DialogFactory(factory);
        btnExport.disableProperty().bind(disableExportProperty);
        btnSave.disableProperty().bind(disableRelationProperty);
        relationTab.disableProperty().bind(disableRelationProperty);
        glassPane.visibleProperty().bind(busyProperty);
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
        boolean empty = nodes.isEmpty();
        disableRelationProperty.set(empty);
        disableExportProperty.set((exportFile == null) || empty);
    }

    @FXML
    void export(final ActionEvent event) {

        if (exportFile != null) {
            Platform.runLater(() -> {
                busyProperty.set(true);
                try {
                    FileWriter writer = new FileWriter(exportFile);
                    writer.write(createExportString());
                    writer.flush();
                } catch (IOException exc) {
                    getLogger().warn(exc.getMessage(), exc);
                    dialogFactory.create(exc).showAndWait();
                } finally {
                    getLogger().info("finished file export");
                }
                busyProperty.set(false);
            });

        }
    }

    private String createExportString() {
        ModelStringFactory factory = new ModelStringFactory(getLookupProvider().getLookup());

        return factory.create();
    }

    @FXML
    void settings(final ActionEvent event) {
        TextInputDialog dlg = dialogFactory.createRestUrlDialog(settings.getRestUrl());
        dlg.showAndWait().ifPresent(url -> settings.setRestUrl(url));
    }

    @FXML
    void save(ActionEvent event) {
        Lookup lookup = getLookupProvider().getLookup();
        
        Collection<? extends Project> projects = lookup.lookupAll(Project.class);
        projectRepository.save(projects);
        
        Collection<? extends Technology> techs = lookup.lookupAll(Technology.class);
        technologyRepository.save(techs);

    }
}
