package org.inno.control;

import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.controlsfx.validation.ValidationSupport;
import static org.controlsfx.validation.Validator.createEmptyValidator;
import org.inno.model.Technology;

/**
 * Controller for the 'Technologie' Tab.
 *
 * @author spindizzy
 */
public class TechnologyNodeController extends AbstractNodeController<Technology>{

    @FXML
    private TextField txtLayer;
    
    @FXML
    private TextField txtGroupId;
    
    @FXML
    private TextField txtArtifactId;
    
    @FXML
    private ComboBox<Color> cmbState;
    
    @FXML
    private TableView tblTech;
    
    private Technology model;

    public TechnologyNodeController() {
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
        txtGroupId.textProperty().bindBidirectional(model.groupIdProperty());
        txtArtifactId.textProperty().bindBidirectional(model.artifacIdProperty());
        
        tblTech.setItems(tableItems);
    }

    @Override
    void doAdd() {
        tableItems.add(model);
        getContext().getContent().add(model);
        model = new Technology();
    }
}
