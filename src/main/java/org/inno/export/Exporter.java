package org.inno.export;

/**
 *
 * @author spindizzy
 */
public interface Exporter<T> {
    
    void export(T model);
}
