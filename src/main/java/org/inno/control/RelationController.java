package org.inno.control;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import java.util.Set;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.inno.model.Project;
import org.inno.model.Technology;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 * Controller to create a relation between {@link Project} and
 * {@link Technology}.
 *
 * @author spindizzy
 */
public class RelationController extends AbstractController implements LookupListener {

    private final ObservableList<Technology> techList;

    private final ObservableList<Project> projList;

    private final Result<Technology> techResult;

    private final Result<Project> projResult;

    @FXML
    private TableView tableProj;

    @FXML
    private TableView tableTech;
    
    private Optional<Project> selectedProject;

    public RelationController() {
        techList = observableArrayList();
        projList = observableArrayList();
        techResult = getContext().getLookup().lookupResult(Technology.class);
        projResult = getContext().getLookup().lookupResult(Project.class);
        techResult.addLookupListener(this);
        projResult.addLookupListener(this);
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
            if(!selectedIndizes.isEmpty()){
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
            if(selectedProject.isPresent()){
                Project project = selectedProject.get();
                project.clear();
                List<Integer> selectedIndizes = c.getList();
                selectedIndizes.forEach(index -> project.add(techList.get(index)));
            }
        });
    }

    @FXML
    void update(ActionEvent event){
        resultChanged(null);
    }

    @Override
    public void resultChanged(LookupEvent le) {
        techList.clear();
        techList.addAll(techResult.allInstances());
        projList.clear();
        projList.addAll(projResult.allInstances());
    }
    
    @FXML
    void updateModel(ActionEvent event){
        if(selectedProject.isPresent()){
            Project model = selectedProject.get();
            getContext().getContent().remove(model);
            getContext().getContent().add(model);
        }
    }

}
