package org.inno.control;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import org.inno.model.State;

/**
 *
 * @author spindizzy
 */
public class StateComboBox extends ComboBox<State> {

    public StateComboBox() {
        setButtonCell(new ColorCell());
        setCellFactory((ListView<State> p) -> new ColorCell());
    }
}
