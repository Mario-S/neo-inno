package org.inno.converter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;


/**
 * @author spindizzy
 */
public class StringToStringPropertyConverterFactory
    implements ConverterFactory<String, StringProperty> {
    @Override
    public <T extends StringProperty> Converter<String, T> getConverter(final Class<T> type) {
        return new StringToStringPropertyConverter<>();
    }

    private final class StringToStringPropertyConverter<S extends String, E extends StringProperty>
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
}
