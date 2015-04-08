package org.inno.export;


/**
 * @author spindizzy
 */
public interface Exporter<T> {
    String export(T type);
}
