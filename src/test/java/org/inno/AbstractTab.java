package org.inno;

import java.net.URL;
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
abstract class AbstractTab extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getResource();
        Parent root = FXMLLoader.load(resource,
                ResourceBundle.getBundle("org.inno.bundles.bundle"));
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected abstract URL getResource();

}
