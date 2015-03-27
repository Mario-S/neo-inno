package org.inno.control;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

/**
 *
 * @author spindizzy
 */
public class ColorComboBox extends ComboBox<Color> {

    public ColorComboBox() {
        setButtonCell(new ColorCell());
        setCellFactory((ListView<Color> p) -> new ColorCell());
    }
}
