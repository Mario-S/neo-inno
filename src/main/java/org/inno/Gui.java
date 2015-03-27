package org.inno;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author spindizzy
 */
public class Gui extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = getParent();
        Scene scene = new Scene(root, 940, 400);
    
        stage.setTitle("Neo4J NodeFactory");
        stage.setScene(scene);
        stage.show();
    }

    Parent getParent() throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("org.inno.bundles.bundle");
        return FXMLLoader.load(getClass().getResource("node_factory.fxml"), bundle);
    }
    
}