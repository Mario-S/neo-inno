package org.inno.converter;

import javafx.beans.property.StringProperty;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;


/**
 * @author spindizzy
 */
public class StringPropertyToStringConverterFactory
    implements ConverterFactory<StringProperty, String> {
    @Override
    public <T extends String> Converter<StringProperty, T> getConverter(final Class<T> type) {
        return new StringPropertyToStringConverter<>();
    }

    private final class StringPropertyToStringConverter<E extends StringProperty, S extends String>
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
}
