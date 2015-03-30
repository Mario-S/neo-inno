package org.inno.control;

import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;

import static org.controlsfx.validation.Validator.createEmptyValidator;
import org.inno.model.Node;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
abstract class AbstractNodeController<T extends Node> extends AbstractController{
    
    @FXML
    protected TextField txtName;
    
    @FXML
    protected TextField txtVersion;
    
    private final ValidationSupport validationSupport;
    
    protected final ObservableList<T> tableItems;
    

    public AbstractNodeController() {
        validationSupport = new ValidationSupport();
        tableItems = observableArrayList();
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
