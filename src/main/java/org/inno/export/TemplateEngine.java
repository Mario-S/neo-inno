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
    private static final String PROJECT_TEMPLATE = "neo_project.template";
    private static final String TECHNOLOGY_TEMPLATE = "neo_tech.template";
    private static final String RELATION_TEMPLATE = "neo_relation.template";

    private static final Logger LOG = LoggerFactory.getLogger(TemplateEngine.class);

    private final MustacheFactory mustacheFactory;

    TemplateEngine() {
        mustacheFactory = new DefaultMustacheFactory();
    }

    String parse(Project project) {
        return parse(project, PROJECT_TEMPLATE);
    }
    
    String parse(Technology technology) {
        return parse(technology, TECHNOLOGY_TEMPLATE);
    }
    
    String parse(Entry<Project, Set<Technology>> relation){
        return parse(relation, RELATION_TEMPLATE);
    }
    
    private String parse(Object object, String template){
        StringWriter writer = new StringWriter();
        if (object != null) {
            Mustache mustache = mustacheFactory.compile(template);
            try {
                mustache.execute(writer, object).flush();
            } catch (IOException ex) {
                LOG.warn(ex.getMessage(), ex);
            }
        }
        return writer.toString();
    }

}
