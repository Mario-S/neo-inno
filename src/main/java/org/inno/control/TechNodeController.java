package org.inno.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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
    
    @FXML
    private ComboBox<Color> cmbState;

    @Override
    protected void initialize(ValidationSupport validationSupport, MessageFactory factory) {
        super.initialize(validationSupport, factory);
        validationSupport.registerValidator(txtLayer, createEmptyValidator(factory.getMessage("err.req.layer")));
        validationSupport.registerValidator(cmbState, createEmptyValidator(factory.getMessage("err.req.state")));
    }
    
    
}
