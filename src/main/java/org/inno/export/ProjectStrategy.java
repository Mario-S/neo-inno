package org.inno.export;

import org.inno.model.Project;

/**
 *
 * @author spindizzy
 */
class ProjectStrategy extends AbstractStrategy<Project>{

    @Override
    public String toString(Project t) {
        return getTemplateEngine().parse(t);
    }
    
}
