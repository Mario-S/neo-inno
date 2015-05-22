package org.inno.control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
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


/**
 * Controller to create the CYPHER nodes.
 *
 * @author spindizzy
 */
public class MainController extends AbstractController implements LookupListener {
    private final BooleanProperty disableExportProperty;

    private final BooleanProperty disableRelationProperty;

    private final Result<org.inno.model.Node> result;

    @FXML
    private TextField txtFile;

    @FXML
    private Button btnCreate;

    @FXML
    private Tab relationTab;

    @FXML
    private Node glassPane;

    private File exportFile;

    private DialogFactory dialogFactory;

    public MainController() {
        disableExportProperty = new SimpleBooleanProperty(true);
        disableRelationProperty = new SimpleBooleanProperty(true);
        result = getContext().getLookup().lookupResult(org.inno.model.Node.class);
        result.addLookupListener(this);
    }

    @Override
    void initialize(final MessageFactory factory) {
        dialogFactory = new DialogFactory(factory);
        btnCreate.disableProperty().bind(disableExportProperty);
        relationTab.disableProperty().bind(disableRelationProperty);
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
            try {
                FileWriter writer = new FileWriter(exportFile);
                writer.write(createExportString());
                writer.flush();
            } catch (IOException exc) {
                getLogger().warn(exc.getMessage(), exc);
                dialogFactory.create(exc).showAndWait();
            }
                }
        }
    }

    private String createExportString() {
        ModelStringFactory factory = new ModelStringFactory(getContext().getLookup());

        return factory.create();
    }
    
    @FXML
    void settings(final ActionEvent event){
        dialogFactory.create(new UnsupportedOperationException("not supported yet")).showAndWait();
    }
   
=======
