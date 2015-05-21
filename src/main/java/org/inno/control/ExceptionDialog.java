package org.inno.control;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * Dialog to show a {@link Throwable}.
 * @author spindizzy
 */
final class ExceptionDialog extends Alert {

    private static final String EXC_DIALOG_HEADER = "exc.appeared";
    private static final String EXC_DIALOG_TITLE = "exc.dialog.title";
    private static final String EXC_STACKTRACE = "exc.stacktrace";

    private final MessageFactory messageFactory;
    
    private TextArea textArea;

    ExceptionDialog(MessageFactory messageFactory) {
        super(AlertType.ERROR);
        this.messageFactory = messageFactory;
        init();
    }

    private void init() {
        setTitle(messageFactory.getMessage(EXC_DIALOG_TITLE));
        setHeaderText(messageFactory.getMessage(EXC_DIALOG_HEADER));
        
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(new Label(messageFactory.getMessage(EXC_STACKTRACE)), 0, 0);
        expContent.add(textArea, 0, 1);

        getDialogPane().setExpandableContent(expContent);
    }
    
    void setThrowable(Throwable throwable) {
        setContentText(throwable.getLocalizedMessage());
        
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        textArea.setText(sw.toString());
    }

}
