package org.inno.converter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import org.inno.model.State;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;


/**
 * @author spindizzy
 */
public class StringToStatePropertyConverterFactory
    implements ConverterFactory<String, ObjectProperty> {
    @Override
    public <T extends ObjectProperty> Converter<String, T> getConverter(final Class<T> type) {
        return new StringToStatePropertyConverter<>();
    }

    private final class StringToStatePropertyConverter<S extends String, E extends ObjectProperty>
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
}
