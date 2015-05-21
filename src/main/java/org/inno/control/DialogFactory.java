package org.inno.control;

import javafx.scene.control.Alert;

/**
 * Factory to produce dialogs.
 * @author spindizzy
 */
class DialogFactory {

    private ExceptionDialog exceptionDialog;

    private final MessageFactory messageFactory;

    DialogFactory(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    Alert create(Throwable exception) {
        if(exceptionDialog == null){
            exceptionDialog = new ExceptionDialog(messageFactory);
        }
        exceptionDialog.setThrowable(exception);
        
        return exceptionDialog;
    }

}
