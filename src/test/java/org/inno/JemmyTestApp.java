package org.inno;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author schroeder
 */
public class JemmyTestApp extends Application {

    private static final int SIZE = 500;
    private static final VBox PARENT = new VBox();

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(PARENT);
        stage.setScene(scene);

        stage.setWidth(SIZE);
        stage.setHeight(SIZE);

        stage.show();
    }

    /**
     * Adds a child to the parent.
     *
     * @param content
     */
    public static void addContent(Node content) {
        PARENT.getChildren().add(content);
    }

    /**
     * Removes a child.
     *
     * @param content
     */
    public static void removeContent(Node content) {
        PARENT.getChildren().remove(content);
    }
}