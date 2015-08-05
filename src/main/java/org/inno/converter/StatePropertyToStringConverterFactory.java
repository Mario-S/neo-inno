package org.inno.converter;

import javafx.beans.property.ObjectProperty;

import org.inno.model.State;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;


/**
 * @author spindizzy
 */
public class StatePropertyToStringConverterFactory
    implements ConverterFactory<ObjectProperty, String> {
    @Override
    public <T extends String> Converter<ObjectProperty, T> getConverter(final Class<T> type) {
        return new ObjectPropertyToStringConverter<>();
    }

    private final class ObjectPropertyToStringConverter<E extends ObjectProperty, S extends String>
        implements Converter<E, S> {
        @Override
        public S convert(final E e) {
            if (e != null) {
                State state = (State) e.getValue();

                return (S) state.name();
            } else {
                return null;
            }
        }
    }
}
