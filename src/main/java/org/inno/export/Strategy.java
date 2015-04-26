package org.inno.export;

/**
 *
 * @author spindizzy
 */
interface Strategy<T> {
    String BR = "\n";
    String toString(T t);
}
