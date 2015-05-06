package org.inno.export;

import org.inno.model.Project;

/**
 *
 * @author spindizzy
 */
class DefaultStrategy<T> implements Strategy<T>{
    
    private final TemplateEngine templateEngine;

    public DefaultStrategy() {
        this.templateEngine = new TemplateEngine();
    }

    protected TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
    
    @Override
    public String toString(T t) {
        return getTemplateEngine().parse(t);
    }

}
