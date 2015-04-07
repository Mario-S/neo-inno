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

import java.util.Collection;


/**
 * Controller to create the CYPHER statements.
 *
 * @author spindizzy
 */
public class MainController extends AbstractController implements LookupListener {
    @FXML
    private TextField txtFile;

    @FXML
    private Button btnCreate;

    @FXML
    private Tab relationTab;

    private final BooleanProperty disableProperty;

    private final Result<org.inno.model.Node> result;

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
        }
    }

    @Override
    public void resultChanged(final LookupEvent le) {
        Result<?> res = (Result) le.getSource();
        Collection<?> nodes = res.allInstances();
        disableProperty.set(nodes.isEmpty());
    }

    @FXML
    void export(final ActionEvent event) {
        // TODO implement
    }
}
