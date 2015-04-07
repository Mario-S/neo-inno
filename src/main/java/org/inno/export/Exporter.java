package org.inno.export;

import java.util.List;


/**
 * @author spindizzy
 */
public interface Exporter<T> {
    String export(List<T> models);
}
