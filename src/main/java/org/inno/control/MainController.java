package org.inno.control;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * Controller to create the CYPHER statements
 *
 * @author spindizzy
 */
public class MainController {
    
    @FXML
    private TextField txtFile;

    @FXML
    protected void handleFileSelection(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Output File");
        Node node = (Node) event.getSource();
        File file = fileChooser.showOpenDialog(node.getScene().getWindow());
        if(file != null){
            txtFile.setText(file.getPath());
        }
    }

}
