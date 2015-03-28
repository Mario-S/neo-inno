package org.inno.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;

import static org.controlsfx.validation.Validator.createEmptyValidator;

/**
 *
 * @author spindizzy
 */
abstract class AbstractNodeController extends AbstractController{
    
    @FXML
    protected TextField txtName;
    
    @FXML
    protected TextField txtVersion;
    
    private final ValidationSupport validationSupport;
    

    public AbstractNodeController() {
        validationSupport = new ValidationSupport();
    }
    
    @Override
    protected void initialize(MessageFactory factory){
        initialize(validationSupport, factory);
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
