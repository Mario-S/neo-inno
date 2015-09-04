/*
 * Created by Schuetze Consulting Informationssysteme AG, Berlin.
 */
package org.inno.converter;

import javafx.beans.property.ObjectProperty;

import org.inno.model.State;

import org.springframework.core.convert.converter.Converter;


/**
 * @author spindizzy
 */
public final class StatePropertyToStringConverter<E extends ObjectProperty<State>, S extends String>
    implements Converter<E, S> {
    @Override
    public S convert(final E e) {
        if (e != null) {
            State state = e.getValue();

            return (S) state.name();
        } else {
            return null;
        }
    }
}
