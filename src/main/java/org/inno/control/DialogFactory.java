package org.inno.control;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author spindizzy
 */
class DialogFactory {

    private static final String EXC_DIALOG_HEADER = "exc.appeared";
    private static final String EXC_DIALOG_TITLE = "exc.dialog.title";
    private static final String EXC_STACKTRACE = "exc.stacktrace";

    private final MessageFactory messageFactory;

    DialogFactory(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    private String getMessage(String key) {
        return messageFactory.getMessage(key, new Object());
    }

    Alert createExceptionDialog(Throwable exception) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(getMessage(EXC_DIALOG_TITLE));
        alert.setHeaderText(getMessage(EXC_DIALOG_HEADER));
        alert.setContentText(exception.getLocalizedMessage());

        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        String exceptionText = sw.toString();

        Label label = new Label(getMessage(EXC_STACKTRACE));

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);
        return alert;
    }

}
