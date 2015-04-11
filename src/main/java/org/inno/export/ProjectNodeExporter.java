package org.inno.export;

import java.util.Collection;
import org.inno.model.Project;

/**
 *
 * @author spindizzy
 */
class ProjectNodeExporter extends NodeExporter<Project> {

    ProjectNodeExporter(Strategy<Project> strategy) {
        super(strategy);
    }

    @Override
    public String export(Collection<Project> projects) {
        StringBuilder builder = new StringBuilder();
        projects.forEach(p -> builder.append(getStrategy().toString(p)));
        return builder.toString();
    }

}
