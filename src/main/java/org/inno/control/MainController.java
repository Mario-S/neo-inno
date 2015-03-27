package org.inno.control;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.datafx.controller.FXMLController;
import org.datafx.controller.context.ApplicationContext;
import org.datafx.controller.context.FXMLApplicationContext;

/**
 * Controller to create the CYPHER statements
 *
 * @author spindizzy
 */
@FXMLController("node_factory.fxml")
public class MainController {
    
    @FXMLApplicationContext
    private ApplicationContext applicationContext;
    
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
