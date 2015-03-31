package org.inno.control;

import org.inno.model.Project;

/**
 * Controller for the 'Projekt' Tab.
 *
 * @author spindizzy
 */
public class ProjectNodeController extends AbstractNodeController<Project> {

    private Project model;

    public ProjectNodeController() {
        createModel();
    }

    private void createModel() {
        model = new Project();
    }

    @Override
    Project getModel() {
        return model;
    }

    @Override
    void onPostAdd() {
        createModel();
    }


}
