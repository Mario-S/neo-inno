package org.inno.export;

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
