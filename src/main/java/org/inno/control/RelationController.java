package org.inno.control;

import java.util.Collection;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
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
public class RelationController extends AbstractController {

    private final ObservableList<Technology> techList;

    private final ObservableList<Project> projList;

    private final Result<Technology> techResult;

    private final Result<Project> projResult;

    @FXML
    private TableView tableProj;

    @FXML
    private TableView tableTech;

    public RelationController() {
        techList = observableArrayList();
        projList = observableArrayList();
        techResult = getContext().getLookup().lookupResult(Technology.class);
        projResult = getContext().getLookup().lookupResult(Project.class);
        techResult.addLookupListener(new TechnologyResultListener());
        projResult.addLookupListener(new ProjectResultListener());
    }

    @Override
    void initialize(MessageFactory factory) {
        tableTech.setItems(techList);
        tableProj.setItems(projList);
    }

    private class TechnologyResultListener implements LookupListener {

        @Override
        public void resultChanged(LookupEvent le) {
            Result<Technology> res = (Result<Technology>) le.getSource();
            techList.clear();
            techList.addAll(res.allInstances());
        }
    }

    private class ProjectResultListener implements LookupListener {

        @Override
        public void resultChanged(LookupEvent le) {
            Result<Project> res = (Result<Project>) le.getSource();
            projList.clear();
            projList.addAll(res.allInstances());
        }

    }
}
