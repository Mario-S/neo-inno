package org.inno.export;

import java.util.Collection;
import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
public interface NodeExportable<T extends Node> extends Exportable<Collection<T>>{
    
}
