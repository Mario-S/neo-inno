package org.inno.control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;
import static org.controlsfx.validation.Validator.createEmptyValidator;

/**
 * Controller for the 'Technologie' Tab.
 *
 * @author spindizzy
 */
public class TechNodeController extends AbstractNodeController{

    @FXML
    private TextField txtLayer;

    @Override
    protected void initialize(ValidationSupport validationSupport, MessageFactory factory) {
        super.initialize(validationSupport, factory);
        validationSupport.registerValidator(txtLayer, createEmptyValidator(factory.getMessage("err.req.layer")));
    }
    
    
}
