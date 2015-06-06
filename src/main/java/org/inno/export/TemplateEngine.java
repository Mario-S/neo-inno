package org.inno.export;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;

/**
 *
 * @author spindizzy
 */
final class TemplateEngine<T> {

    private static final String TEMPLATE = ".template";

    private static final Logger LOG = LoggerFactory.getLogger(TemplateEngine.class);

    private final MustacheFactory mustacheFactory;

    TemplateEngine() {
        mustacheFactory = new DefaultMustacheFactory();
    }

    String parse(T t) {
        String templateName = createTemplateName(t);
        return parse(t, templateName);
    }

    String parse(T t, String templateName) {
        StringWriter writer = new StringWriter();
        Mustache mustache = mustacheFactory.compile(templateName);
        try {
            mustache.execute(writer, t).flush();
        } catch (IOException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
        return writer.toString();
    }

    private String createTemplateName(T t) {
        Class<?> clazz = t.getClass();
        String className = clazz.getName();
        return new StringBuilder().append(className).append(TEMPLATE).toString();
    }

}
