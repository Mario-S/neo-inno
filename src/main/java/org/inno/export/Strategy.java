package org.inno.export;

/**
 *
 * @author Mario
 */
interface Strategy<T> {
    String BR = "\n";
    String toString(T t);
}
