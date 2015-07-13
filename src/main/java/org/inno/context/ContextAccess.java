package org.inno.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author spindizzy
 */
public enum ContextAccess {
    Instance;

    private final ApplicationContext context;

    private ContextAccess() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public ApplicationContext getContext() {
        return context;
    }
}
