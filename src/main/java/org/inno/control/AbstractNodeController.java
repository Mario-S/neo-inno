package org.inno.control;

import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;

import static org.controlsfx.validation.Validator.createEmptyValidator;
import org.inno.model.Node;
import org.openide.util.lookup.InstanceContent;

/**
 * Parent class for controller dealing with {@link Node}
 *
 * @author spindizzy
 */
abstract class AbstractNodeController<T extends Node> extends AbstractController {

    @FXML
    protected TextField txtName;

    @FXML
    protected TextField txtVersion;

    @FXML
    protected TableView table;

    private final ValidationSupport validationSupport;

    private final ObservableList<T> modelList;

    public AbstractNodeController() {
        validationSupport = new ValidationSupport();
        modelList = observableArrayList();
        modelList.addListener(new ModelListChangeListener());
    }

    @Override
    protected void initialize(MessageFactory factory) {
        initialize(validationSupport, factory);
    }

    protected void initialize(ValidationSupport validationSupport, MessageFactory factory) {
        validationSupport.registerValidator(txtName, createEmptyValidator(factory.getMessage("err.req.name")));
        validationSupport.registerValidator(txtVersion, createEmptyValidator(factory.getMessage("err.req.version")));

        txtName.textProperty().bindBidirectional(getModel().nameProperty());
        txtVersion.textProperty().bindBidirectional(getModel().versionProperty());

        table.setItems(getModelList());
    }

    /**
     * Action handling for the button to add a new row to the table.
     *
     * @param event
     */
    @FXML
    protected void addToTable(ActionEvent event) {
        if (!validationSupport.isInvalid()) {
            modelList.add(getModel());
            onPostAdd();
        }
    }

    abstract T getModel();

    /**
     * This method is called after a model was added to the list.
     */
    abstract void onPostAdd();

    protected ObservableList<T> getModelList() {
        return modelList;
    }

    /**
     * Listener for changes in the model list.
     */
    private class ModelListChangeListener implements ListChangeListener<T> {

        @Override
        public void onChanged(Change<? extends T> change) {

            InstanceContent content = getContext().getContent();
            change.next();
            if (change.wasAdded()) {
                change.getAddedSubList().forEach(n -> content.add(n));
            }
        }

    }

}
