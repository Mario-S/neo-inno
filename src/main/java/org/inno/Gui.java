package org.inno;

import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.stage.Stage;

import java.io.IOException;

import java.util.ResourceBundle;


/**
 * Entry point.
 *
 * @author spindizzy
 */
public class Gui extends Application {
    private final SpringFxmlLoader loader = new SpringFxmlLoader();

    @Override
    public void start(final Stage stage) throws IOException {
        Parent root = getParent();
        Scene scene = new Scene(root, 950, 500);

        stage.getIcons().add(
            new Image("http://www.afspc.af.mil/shared/media/ggallery/hires/AFG-060524-001.jpg"));
        stage.setTitle("Neo4J NodeFactory");
        stage.setScene(scene);
        stage.show();
    }

    Parent getParent() throws IOException {
        return loader.load(getClass().getResource("node_factory.fxml"),
                ResourceBundle.getBundle("org.inno.bundles.bundle"));
    }
}
