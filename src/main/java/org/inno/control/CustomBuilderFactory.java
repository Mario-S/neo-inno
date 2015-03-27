package org.inno.control;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
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
        if (type == ColorComboBox.class) {
            builder = new ColorComboBoxBuilder();
        }else{
            builder = defaultBuilderFactory.getBuilder(type);
        }
        return builder;
    }

    private class ColorComboBoxBuilder implements Builder<ColorComboBox> {

        @Override
        public ColorComboBox build() {
            return new ColorComboBox();
        }
    }
}
