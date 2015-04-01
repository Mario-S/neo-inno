package org.inno.control;

import java.util.EnumMap;
import java.util.Map;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.inno.model.State;

/**
 *
 * @author spindizzy
 */
class ColorCell extends ListCell<State> {

    private final Rectangle rectangle;
    
    private static final Map<State, Color> ENUM_MAP = new EnumMap<>(State.class);
    
    static {
        ENUM_MAP.put(State.Red, Color.RED);
        ENUM_MAP.put(State.Yellow, Color.YELLOW);
        ENUM_MAP.put(State.Green, Color.GREEN);
    }

    ColorCell() {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        rectangle = new Rectangle(20, 10);
        rectangle.setStroke(Color.BLACK);
    }

    @Override
    protected void updateItem(State item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setGraphic(null);
        } else {
            rectangle.setFill(ENUM_MAP.get(item));
            setGraphic(rectangle);
        }
    }
}
