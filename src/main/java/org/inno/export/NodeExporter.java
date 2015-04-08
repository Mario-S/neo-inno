package org.inno.export;

import java.util.List;
import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
public interface NodeExporter<T extends Node> extends Exporter<List<T>>{
    
    default String exportCommon(Node node){
        StringBuilder builder = new StringBuilder();
        builder.append(node.getName()).append(node.getVersion());
        return builder.toString();
    }
}
