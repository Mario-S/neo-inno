package org.inno.control;

import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javax.annotation.PostConstruct;
import org.inno.model.Project;
import org.inno.model.Technology;
import org.springframework.stereotype.Component;

/**
 * Controller to create a relation between {@link Project} and
 * {@link Technology}.
 *
 * @author spindizzy
 */
@Component
public class RelationController extends AbstractController {

    private final ObservableList<Technology> techList;

    private final ObservableList<Project> projList;

    private ListLookupListener<Technology> techListner;

    private ListLookupListener<Project> projListner;

    @FXML
    private TableView tableProj;

    @FXML
    private TableView tableTech;

    private Optional<Project> selectedProject;

    public RelationController() {
        techList = observableArrayList();
        projList = observableArrayList();
    }

    @Override
    protected void afterPropertiesSet() {
        techListner = new ListLookupListener<>(techList, getContext().getLookup().lookupResult(Technology.class));
        projListner = new ListLookupListener<>(projList, getContext().getLookup().lookupResult(Project.class));
    }

    @Override
    void initialize(MessageFactory factory) {
        tableProj.setItems(projList);
        tableTech.setItems(techList);
        addChangeListenerToProjectTable();
        addChangeListenerToTechnologyTable();
    }

    private void addChangeListenerToProjectTable() {
        tableProj.getSelectionModel().getSelectedIndices().addListener((ListChangeListener.Change c) -> {
            selectedProject = empty();
            List<Integer> selectedIndizes = c.getList();
            if (!selectedIndizes.isEmpty()) {
                tableTech.getSelectionModel().clearSelection();
                Integer first = selectedIndizes.iterator().next();
                Project project = projList.get(first);
                project.getTechnologies().forEach(t -> tableTech.getSelectionModel().select(t));
                selectedProject = of(project);
            }
        });
    }

    private void addChangeListenerToTechnologyTable() {
        tableTech.getSelectionModel().getSelectedIndices().addListener((ListChangeListener.Change c) -> {
            if (selectedProject.isPresent()) {
                Project project = selectedProject.get();
                project.clear();
                List<Integer> selectedIndizes = c.getList();
                selectedIndizes.forEach(index -> project.add(techList.get(index)));
            }
        });
    }

    @FXML
    void update(ActionEvent event) {
    }

}
