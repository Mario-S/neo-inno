package org.inno.export;

import java.io.IOException;
import org.inno.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import static org.apache.commons.beanutils.BeanUtils.copyProperties;
import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
final class TemplateEngine {
    private static final String PROJECT_TEMPLATE = "neo_project.template";

    private static final Logger LOG = LoggerFactory.getLogger(TemplateEngine.class);

    private final MustacheFactory mustacheFactory = new DefaultMustacheFactory();
    
    private final Mustache projectMustache;

    TemplateEngine() {
        projectMustache = mustacheFactory.compile(PROJECT_TEMPLATE);
    }

    String parse(Project project) {
        StringWriter writer = new StringWriter();
        if (project != null) {
            try {
                ExportNode copy = copy(project);
                projectMustache.execute(writer, copy).flush();
            } catch (IOException ex) {
                LOG.warn(ex.getMessage(), ex);
            }
        }
        return writer.toString();
    }

    private ExportNode copy(Node node){
        ExportNode expNode = new ExportNode();
        try {
            copyProperties(expNode, node);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
        
        return expNode;
    }
}
