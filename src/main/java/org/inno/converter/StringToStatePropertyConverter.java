/*
 * Created by Schuetze Consulting Informationssysteme AG, Berlin.
 */
package org.inno.converter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.inno.model.State;

import org.springframework.core.convert.converter.Converter;


/**
 * @author spindizzy
 */
public final class StringToStatePropertyConverter<S extends String, E extends ObjectProperty<State>>
    implements Converter<S, E> {
    @Override
    public E convert(final S s) {
        if (s != null) {
            State state = State.valueOf(s);

            return (E) new SimpleObjectProperty(state);
        } else {
            return null;
        }
    }
}
