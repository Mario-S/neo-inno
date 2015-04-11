package org.inno.export;

import java.util.List;
import org.inno.model.Node;

/**
 *
 * @author spindizzy
 */
public interface NodeExportable<T extends Node> extends Exportable<List<T>>{
    
}
