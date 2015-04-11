package org.inno.export;

import org.inno.model.Project;

/**
 *
 * @author spindizzy
 */
class CypherProjectStrategy extends AbstractCypherNodeStrategy<Project>{

    @Override
    public String toString(Project t) {
        StringBuilder builder = new StringBuilder();
        builder.append(extractCommon(t)).append(BR);
        return builder.toString();
    }
    
}
