package org.inno.control;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author spindizzy
 */
public class ColorComboBox extends ComboBox<Color> {

    public ColorComboBox() {
        setButtonCell(new ColorCell());
        setCellFactory((ListView<Color> p) -> new ColorCell());
    }

    private class ColorCell extends ListCell<Color> {
        private final Rectangle rectangle;

        ColorCell() {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            rectangle = new Rectangle(20, 10);
            rectangle.setStroke(Color.BLACK);
        }

        @Override
        protected void updateItem(Color item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setGraphic(null);
            } else {
                rectangle.setFill(item);
                setGraphic(rectangle);
            }
        }
    }

}
