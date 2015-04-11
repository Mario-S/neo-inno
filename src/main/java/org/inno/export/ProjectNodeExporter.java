package org.inno.export;

import java.util.List;
import org.inno.model.Project;

/**
 *
 * @author spindizzy
 */
class ProjectNodeExporter extends AbstractNodeExporter<Project> {

    ProjectNodeExporter(Strategy<Project> strategy) {
        super(strategy);
    }

    @Override
    public String export(List<Project> projects) {
        AbstractCypherNodeStrategy strategy = (AbstractCypherNodeStrategy) getStrategy();
        StringBuilder builder = new StringBuilder();
        projects.forEach(p -> builder.append(strategy.exportCommon(p)));
        return builder.toString();
    }

}
