package org.inno.control;

import org.inno.util.ResourceBundleLoader;
import org.inno.util.MessageFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    private static final ResourceBundleLoader LOADER = ResourceBundleLoader.Instance;

    public AbstractNodeController() {
        validationSupport = new ValidationSupport();
    }
    
    @FXML
    public void initialize(){
        initialize(validationSupport, LOADER.getFactory());
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
