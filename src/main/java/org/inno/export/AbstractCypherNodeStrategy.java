package org.inno.export;

import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
abstract class AbstractCypherNodeStrategy<T extends Node> implements Strategy<T>{
    
    protected String exportCommon(Node node){
        StringBuilder builder = new StringBuilder();
        builder.append(node.getName()).append(node.getVersion());
        return builder.toString();
    }

}
