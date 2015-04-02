package org.inno.control;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import org.inno.model.State;

/**
 * {@link ListCell} for the {@link State}.
 * @author spindizzy
 */
class StateListCell extends ListCell<State> {

    private final StateColorShape shape;
    
    StateListCell() {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        shape = new StateColorShape();
    }

    @Override
    protected void updateItem(State item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setGraphic(null);
        } else {
            shape.setState(item);
            setGraphic(shape);
        }
    }
}
