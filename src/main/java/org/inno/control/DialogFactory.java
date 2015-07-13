package org.inno.control;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;


/**
 * Factory to produce dialogs.
 *
 * @author spindizzy
 */
class DialogFactory {
    private ExceptionDialog exceptionDialog;

    private final MessageFactory messageFactory;

    DialogFactory(final MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    Alert create(final Throwable exception) {
        if (exceptionDialog == null) {
            exceptionDialog = new ExceptionDialog(messageFactory);
        }

        exceptionDialog.setThrowable(exception);

        return exceptionDialog;
    }

    TextInputDialog createRestUrlDialog(final String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(messageFactory.getMessage("dialog.restUrl.title"));
        dialog.setHeaderText(messageFactory.getMessage("dialog.restUrl.header"));
        dialog.setContentText(messageFactory.getMessage("dialog.restUrl.content"));

        return dialog;
    }
}
