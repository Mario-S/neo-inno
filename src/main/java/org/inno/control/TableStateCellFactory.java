package org.inno.control;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

import javafx.util.Callback;

import org.inno.model.State;


/**
 * Factory for a {@link TableCell} that shows a {@link State}.
 *
 * @author spindizzy
 */
public class TableStateCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    @Override
    public TableCell<S, T> call(final TableColumn<S, T> param) {
        TableCell<S, T> cell =
            new TableCell<S, T>() {
                @Override
                protected void updateItem(final T item, final boolean empty) {
                    if (!empty && isState(item)) {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

                        StateColorShape shape = new StateColorShape();
                        shape.setState((State) item);
                        setGraphic(shape);
                    }
                }

                private boolean isState(final T item) {
                    return (item != null) && item.getClass().equals(State.class);
                }
            };

        return cell;
    }
}
