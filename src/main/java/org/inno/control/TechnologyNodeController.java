package org.inno.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;
import static org.controlsfx.validation.Validator.createEmptyValidator;
import org.inno.model.State;
import org.inno.model.Technology;
import org.springframework.stereotype.Component;

/**
 * Controller for the 'Technologie' Tab.
 *
 * @author spindizzy
 */
@Component
public class TechnologyNodeController extends AbstractNodeController<Technology> {

    @FXML
    private TextField txtLayer;

    @FXML
    private TextField txtGroupId;

    @FXML
    private TextField txtArtifactId;

    @FXML
    private ComboBox<State> cmbState;

    private Technology model;

    public TechnologyNodeController() {
        createModel();
    }

    private void createModel() {
        model = new Technology();
    }

    @Override
    protected void initialize(ValidationSupport validationSupport, MessageFactory factory) {
        super.initialize(validationSupport, factory);
        validationSupport.registerValidator(txtLayer, createEmptyValidator(factory.getMessage("err.req.layer")));
        validationSupport.registerValidator(cmbState, createEmptyValidator(factory.getMessage("err.req.state")));

    }

    @Override
    Technology getModel() {
        return model;
    }

    @Override
    void onPostAdd() {
        createModel();
    }

    @Override
    void bind(Technology model) {
        txtLayer.textProperty().bindBidirectional(model.layerProperty());
        txtGroupId.textProperty().bindBidirectional(model.groupIdProperty());
        txtArtifactId.textProperty().bindBidirectional(model.artifacIdProperty());
        cmbState.valueProperty().bindBidirectional(model.statusProperty());
    }

    @Override
    void unbind(Technology model) {
        txtLayer.textProperty().unbindBidirectional(model.layerProperty());
        txtGroupId.textProperty().unbindBidirectional(model.groupIdProperty());
        txtArtifactId.textProperty().unbindBidirectional(model.artifacIdProperty());
        cmbState.valueProperty().unbindBidirectional(model.statusProperty());
    }


}
