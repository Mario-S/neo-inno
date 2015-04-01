package org.inno.control;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

/**
 *
 * @author spindizzy
 */
public class CustomBuilderFactory implements BuilderFactory {

    private final JavaFXBuilderFactory defaultBuilderFactory = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        Builder builder;
        if (type == StateComboBox.class) {
            builder = new ColorComboBoxBuilder();
        }else{
            builder = defaultBuilderFactory.getBuilder(type);
        }
        return builder;
    }

    private class ColorComboBoxBuilder implements Builder<StateComboBox> {

        @Override
        public StateComboBox build() {
            return new StateComboBox();
        }
    }
}
