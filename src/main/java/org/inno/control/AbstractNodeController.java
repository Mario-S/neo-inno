package org.inno.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;

import static org.controlsfx.validation.Validator.createEmptyValidator;
import org.datafx.controller.context.ApplicationContext;
import org.datafx.controller.context.FXMLApplicationContext;

/**
 *
 * @author spindizzy
 */
abstract class AbstractNodeController implements Initializable{
    
    @FXMLApplicationContext
    private ApplicationContext applicationContext;
    
    @FXML
    protected TextField txtName;
    
    @FXML
    protected TextField txtVersion;
    
    private final ValidationSupport validationSupport;

    public AbstractNodeController() {
        validationSupport = new ValidationSupport();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle bundle){
        initialize(validationSupport, new MessageFactory(bundle));
    }
    
    protected void initialize(ValidationSupport validationSupport, MessageFactory factory){
        validationSupport.registerValidator(txtName, createEmptyValidator(factory.getMessage("err.req.name")));
        validationSupport.registerValidator(txtVersion, createEmptyValidator(factory.getMessage("err.req.version")));
    }
    
    @FXML
    protected void addToTable(ActionEvent event) {
        if(!validationSupport.isInvalid()){
            doAdd();
        }
    }
    
    abstract void doAdd();
}
