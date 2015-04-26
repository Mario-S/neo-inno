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
 * @author schroeder
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
    
    private final Map<Project,Set<Technology>> model;
    
    private Optional<Project> selectedProject;

    public RelationController() {
        techList = observableArrayList();
        projList = observableArrayList();
        techResult = getContext().getLookup().lookupResult(Technology.class);
        projResult = getContext().getLookup().lookupResult(Project.class);
        techResult.addLookupListener(this);
        projResult.addLookupListener(this);
        model = new HashMap<>();
    }

    @Override
    void initialize(MessageFactory factory) {
        tableProj.setItems(projList);
        tableTech.setItems(techList);
        tableProj.getSelectionModel().getSelectedIndices().addListener((ListChangeListener.Change c) -> {
            selectedProject = empty();
            List<Integer> selected = c.getList();
            if(!selected.isEmpty()){
                tableTech.getSelectionModel().clearSelection();
                Project p = projList.get(selected.iterator().next());
                if(!model.containsKey(p)){
                    model.put(p, new HashSet<>());
                }else{
                    model.get(p).forEach(t -> tableTech.getSelectionModel().select(t));
                }
                selectedProject = of(p);
            }
        });
        tableTech.getSelectionModel().getSelectedIndices().addListener((ListChangeListener.Change c) -> {
            if(selectedProject.isPresent()){
                Set<Technology> technologies = model.get(selectedProject.get());
                List<Integer> selected = c.getList();
                selected.forEach(index -> technologies.add(techList.get(index)));
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
        getContext().getContent().remove(model);
        getContext().getContent().add(model);
    }

}
