package org.inno.export;

import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
abstract class AbstractNodeExporter<T extends Node> implements NodeExportable<T>{
    private Strategy<T> strategy;

    AbstractNodeExporter(Strategy<T> strategy) {
        this.strategy = strategy;
    }

    protected Strategy<T> getStrategy() {
        return strategy;
    }
    
}
