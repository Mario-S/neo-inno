package de.scag.inno.controller;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * Controller to create the CYPHER statements
 *
 * @author schroeder
 */
public class MainController {
    
    @FXML
    private Text txtFile;

    @FXML
    protected void handleFileSelection(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Output File");
        Node node = (Node) event.getSource();
        fileChooser.showOpenDialog(node.getScene().getWindow());
    }

}
