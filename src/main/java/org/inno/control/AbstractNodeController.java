package org.inno.control;

import static com.google.common.collect.Lists.newArrayList;
import java.util.List;
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
    
    private final List<Integer> selectedIndizes;

    AbstractNodeController(ValidationSupport validationSupport) {
        this.validationSupport = validationSupport;
        modelList = observableArrayList();
        modelList.addListener(new ModelListChangeListener());
        selectedIndizes = newArrayList();
    }

    AbstractNodeController() {
        this(new ValidationSupport());
    }

    @Override
    void initialize(MessageFactory factory) {
        initialize(validationSupport, factory);

        bind();
        initializeTable();
    }

    private void initializeTable() {
        table.setItems(getModelList());
        table.getSelectionModel().getSelectedIndices().addListener((ListChangeListener.Change c) -> {
            selectedIndizes.clear();
            selectedIndizes.addAll(c.getList());
        });
    }

    protected void initialize(ValidationSupport validationSupport, MessageFactory factory) {
        validationSupport.registerValidator(txtName, createEmptyValidator(factory.getMessage("err.req.name")));
        validationSupport.registerValidator(txtVersion, createEmptyValidator(factory.getMessage("err.req.version")));
    }

    private void bind() {
        final T model = getModel();
        txtName.textProperty().bindBidirectional(model.nameProperty());
        txtVersion.textProperty().bindBidirectional(model.versionProperty());
        bind(model);
    }

    private void unbind() {
        final T model = getModel();
        txtName.textProperty().unbindBidirectional(model.nameProperty());
        txtVersion.textProperty().unbindBidirectional(model.versionProperty());
        unbind(model);
    }

    /**
     * Action handling to add a new row to the table.
     *
     * @param event
     */
    @FXML
    protected void addToTable(ActionEvent event) {
        if (!validationSupport.isInvalid()) {
            T model = getModel();
            if (!modelList.contains(model)) {
                unbind();
                modelList.add(model);
                onPostAdd();
                bind();
            }
        }
    }

    /**
     * Action handling to remove a row from the table.
     */
    @FXML
    protected void removeFromTable(ActionEvent event) {
        modelList.removeIf(m -> selectedIndizes.contains(modelList.indexOf(m)));
    }

    /**
     * This method returns a single model.
     *
     * @return
     */
    abstract T getModel();

    /**
     * This method is called after a model was added to the list.
     */
    abstract void onPostAdd();

    abstract void bind(T model);

    abstract void unbind(T model);

    /**
     * This method returns a list of models.
     *
     * @return
     */
    protected ObservableList<T> getModelList() {
        return modelList;
    }

    /**
     * Listener for changes in the model list.
     */
    private class ModelListChangeListener implements ListChangeListener<T> {

        @Override
        public void onChanged(Change<? extends T> change) {

            InstanceContent content = getLookupProvider().getContent();
            change.next();
            if (change.wasAdded()) {
                change.getAddedSubList().forEach(n -> content.add(n));
            }else if(change.wasRemoved()){
                change.getRemoved().forEach(n -> content.remove(n));
            }
        }

    }

}
