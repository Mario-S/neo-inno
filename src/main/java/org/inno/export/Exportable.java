package org.inno.export;


/**
 * @author spindizzy
 */
public interface Exportable<T> {
    String export(T type);
}
