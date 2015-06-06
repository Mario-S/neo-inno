package org.inno.export;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author spindizzy
 */
final class TemplateEngine<T> {

    private static final String TEMPLATE = ".template";

    private static final Logger LOG = LoggerFactory.getLogger(TemplateEngine.class);

    private final Handlebars handlebars;

    TemplateEngine() {
        TemplateLoader loader = new ClassPathTemplateLoader();
//        loader.setPrefix("/templates");
        loader.setSuffix(TEMPLATE);
        handlebars = new Handlebars(loader);
    }

    String parse(T t) {
        String templateName = createTemplateName(t);
        return parse(t, templateName);
    }

    String parse(T t, String templateName) {
        StringBuilder builder = new StringBuilder();

        try {
            Template template = handlebars.compile(templateName);
            builder.append(template.apply(t));
        } catch (IOException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
        return builder.toString();
    }

    private String createTemplateName(T t) {
        Class<?> clazz = t.getClass();
        return clazz.getName();
    }

}
