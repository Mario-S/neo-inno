package org.inno.export;

import java.util.Map.Entry;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
class RelationStrategy extends AbstractStrategy<Entry<Project, Set<Technology>>>{

    @Override
    public String toString(Entry<Project, Set<Technology>> entry) {
       return getTemplateEngine().parse(entry);
    }
    
}
