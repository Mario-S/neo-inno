package org.inno.export;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.inno.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author spindizzy
 */
final class TemplateEngine {
    private static final String PROJECT_TEMPLATE = "neo_project";

    private static final Logger LOG = LoggerFactory.getLogger(TemplateEngine.class);

    private final Gson gson = new Gson();

    private String projectTemplate;

    private ScriptEngine engine;

    TemplateEngine() {
        try {
            projectTemplate = readTemplate(PROJECT_TEMPLATE);
            createEngine();
        } catch (IOException | ScriptException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
    }
    

    private void createEngine() throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine eng = engineManager.getEngineByName("nashorn");
        String res = getClass().getResource("mustache.min.js").getFile();
        eng.eval(res);
        this.engine = eng;
    }

    private String readTemplate(String name) throws IOException {
        String res = getClass().getResource(name + ".template").getFile();
        BufferedReader reader = new BufferedReader(new FileReader(res));
        StringBuilder builder = new StringBuilder();
        reader.lines().forEach(line -> builder.append(line));
        return builder.toString();
    }

    private String render(String template, String jsonData) throws ScriptException, NoSuchMethodException {
        Object json = engine.eval("JSON");
        Invocable invocable = (Invocable) engine;
        Object data
                = invocable.invokeMethod(json, "parse", jsonData);
        Object mustache = engine.eval("Mustache");
        return (String) invocable.invokeMethod(
                mustache, "render", template, data);
    }

    Optional<String> parse(Project project) {
        Optional<String> opt = empty();
        if (engine != null && project != null) {
            String jsonData = gson.toJson(project);
            try {
                opt = of(render(projectTemplate, jsonData));
            } catch (ScriptException | NoSuchMethodException ex) {
                LOG.warn(ex.getMessage(), ex);
            }
        }
        return opt;
    }

}
