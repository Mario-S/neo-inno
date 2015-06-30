package org.inno;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

import java.util.ResourceBundle;


/**
 * @author spindizzy
 */
public class Gui extends Application {
    
    private final SpringFxmlLoader loader = new SpringFxmlLoader();
    
    @Override
    public void start(final Stage stage) throws IOException {
        Parent root = getParent();
        Scene scene = new Scene(root, 950, 500);

        stage.setTitle("Neo4J NodeFactory");
        stage.setScene(scene);
        stage.show();
    }

    Parent getParent() throws IOException {
        
        return loader.load(getClass().getResource("node_factory.fxml"), 
                ResourceBundle.getBundle("org.inno.bundles.bundle"));
    }
}
