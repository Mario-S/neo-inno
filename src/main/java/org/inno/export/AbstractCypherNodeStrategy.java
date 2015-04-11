package org.inno.export;

import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
abstract class AbstractCypherNodeStrategy<T extends Node> implements Strategy<T>{
    
    /**
     * This method extracts the fields from the nodes. 
     * Since {@link Node} is a common parent class it can be reused for
     * subclasses.
     * @param node the {@link Node}
     * @return String
     */
    protected String extractCommon(Node node){
        StringBuilder builder = new StringBuilder();
        builder.append(node.getName()).append(node.getVersion());
        return builder.toString();
    }

}
