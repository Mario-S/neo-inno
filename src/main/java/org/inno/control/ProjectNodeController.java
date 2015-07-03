package org.inno.control;

import org.controlsfx.validation.ValidationSupport;
import org.inno.model.Project;
import org.springframework.stereotype.Component;

/**
 * Controller for the 'Projekt' Tab.
 *
 * @author spindizzy
 */
@Component
public class ProjectNodeController extends AbstractNodeController<Project> {

    private Project model;

    ProjectNodeController(ValidationSupport validationSupport) {
        super(validationSupport);
        createModel();
    }

    public ProjectNodeController() {
        createModel();
    }

    private void createModel() {
        model = new Project();
    }

    @Override
    Project getModel() {
        model.setName((txtName != null) ? txtName.getText() : null);
        model.setVersion((txtVersion != null) ? txtVersion.getText() : null);
        return model;
    }

    @Override
    void onPostAdd() {
        createModel();
    }

    @Override
    void bind(Project model) {
    }

    @Override
    void unbind(Project model) {
    }
}
