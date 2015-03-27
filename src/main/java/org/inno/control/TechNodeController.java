package org.inno.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.controlsfx.validation.ValidationSupport;
import static org.controlsfx.validation.Validator.createEmptyValidator;
import org.datafx.controller.FXMLController;
import org.inno.model.Technology;

/**
 * Controller for the 'Technologie' Tab.
 *
 * @author spindizzy
 */
@FXMLController("tab_tech.fxml")
public class TechNodeController extends AbstractNodeController{

    @FXML
    private TextField txtLayer;
    
    @FXML
    private ComboBox<Color> cmbState;
    
    @FXML
    private TableView tblTech;
    
    private Technology model;

    public TechNodeController() {
        model = new Technology();
    }
    
    @Override
    protected void initialize(ValidationSupport validationSupport, MessageFactory factory) {
        super.initialize(validationSupport, factory);
        validationSupport.registerValidator(txtLayer, createEmptyValidator(factory.getMessage("err.req.layer")));
        validationSupport.registerValidator(cmbState, createEmptyValidator(factory.getMessage("err.req.state")));
        
        txtName.textProperty().bindBidirectional(model.nameProperty());
        txtVersion.textProperty().bindBidirectional(model.versionProperty());
        txtLayer.textProperty().bindBidirectional(model.layerProperty());
    }

    @Override
    void doAdd() {
        tblTech.getItems().add(model);
        model = new Technology();
    }
    
    
}
