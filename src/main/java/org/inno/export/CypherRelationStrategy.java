package org.inno.export;

import java.util.Map.Entry;
import java.util.Set;
import org.inno.model.Project;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
class CypherRelationStrategy implements Strategy<Entry<Project, Set<Technology>>>{

    @Override
    public String toString(Entry<Project, Set<Technology>> entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
