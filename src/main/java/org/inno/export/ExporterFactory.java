package org.inno.export;

import java.util.Collection;
import org.inno.model.Node;

/**
 * @author spindizzy
 */
public class ExporterFactory {
    
    public <T extends Node> Exportable<Collection<T>> createNodeExporter(){
        TemplateStrategy<T> strategy = new TemplateStrategy<>();
        return new NodeExporter<>(strategy);
    }
}
