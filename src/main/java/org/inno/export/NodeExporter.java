package org.inno.export;

import java.util.Collection;
import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
class NodeExporter<T extends Node> implements NodeExportable<T>{
    private Strategy<T> strategy;

    NodeExporter(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    protected Strategy<T> getStrategy() {
        return strategy;
    }
    
    @Override
    public String export(Collection<T> nodes) {
        StringBuilder builder = new StringBuilder();
        nodes.forEach(n -> builder.append(getStrategy().toString(n)));
        return builder.toString();
    }
}
