/*
 * Created by Schuetze Consulting Informationssysteme AG, Berlin.
 */
package org.inno.converter;

import javafx.beans.property.StringProperty;

import org.springframework.core.convert.converter.Converter;


/**
 * @author spindizzy
 */
public final class StringPropertyToStringConverter<E extends StringProperty, S extends String>
    implements Converter<E, S> {
    @Override
    public S convert(final E s) {
        if (s != null) {
            return (S) s.getValue();
        } else {
            return null;
        }
    }
}
