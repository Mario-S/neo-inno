/*
 * Created by Schuetze Consulting Informationssysteme AG, Berlin.
 */
package org.inno.converter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.springframework.core.convert.converter.Converter;


/**
 * @author spindizzy
 */
public final class StringToStringPropertyConverter<S extends String, E extends StringProperty>
    implements Converter<S, E> {
    @Override
    public E convert(final S s) {
        if (s != null) {
            return (E) new SimpleStringProperty(s);
        } else {
            return null;
        }
    }
}
