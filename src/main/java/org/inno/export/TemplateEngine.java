package org.inno.export;

import java.io.IOException;
import org.inno.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.util.Map.Entry;
import java.util.Set;
import org.inno.model.Technology;

/**
 *
 * @author spindizzy
 */
final class TemplateEngine {

    private static final Logger LOG = LoggerFactory.getLogger(TemplateEngine.class);

    private final MustacheFactory mustacheFactory;

    TemplateEngine() {
        mustacheFactory = new DefaultMustacheFactory();
    }

    String parse(Project project) {
        return parse(project, Project.class.getSimpleName());
    }
    
    String parse(Technology technology) {
        return parse(technology, Technology.class.getSimpleName());
    }
    
    String parse(Entry<Project, Set<Technology>> relation){
        return parse(relation, Entry.class.getSimpleName());
    }
    
    private String parse(Object object, String className){
        StringWriter writer = new StringWriter();
        if (object != null) {
            String templateName = createTemplateName(className);
            Mustache mustache = mustacheFactory.compile(templateName);
            try {
                mustache.execute(writer, object).flush();
            } catch (IOException ex) {
                LOG.warn(ex.getMessage(), ex);
            }
        }
        return writer.toString();
    }

    private String createTemplateName(String className){
        return new StringBuilder().append(className).append(TEMPLATE).toString();
    }
    private static final String TEMPLATE = ".template";
}
