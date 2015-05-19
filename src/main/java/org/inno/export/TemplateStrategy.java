package org.inno.export;

/**
 *
 * @author spindizzy
 */
class TemplateStrategy<T> implements Strategy<T>{
    
    private final TemplateEngine templateEngine;

    public TemplateStrategy() {
        this.templateEngine = new TemplateEngine();
    }

    @Override
    public String toString(T t) {
        StringBuilder builder = new StringBuilder();
        builder.append(templateEngine.parse(t)).append(BR);
        return builder.toString();
    }

}
