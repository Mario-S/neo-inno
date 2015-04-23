package org.inno.export;

import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
abstract class AbstractStrategy<T> implements Strategy<T>{
    
    private final TemplateEngine templateEngine;

    public AbstractStrategy() {
        this.templateEngine = new TemplateEngine();
    }

    protected TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
    
    

}
