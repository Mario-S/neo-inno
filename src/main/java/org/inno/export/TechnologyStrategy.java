/*
 * 
 */
package org.inno.export;

import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
class TechnologyStrategy extends AbstractStrategy<Technology>{

    @Override
    public String toString(Technology t) {
        return getTemplateEngine().parse(t);
    }
    
}
