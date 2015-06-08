package org.inno.control;

import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

import org.inno.model.State;

import java.util.Optional;


/**
 * Shape for the {@link State}.
 *
 * @author spindizzy
 */
class StateColorShape extends Rectangle {
    StateColorShape() {
        this(20, 10);
    }

    StateColorShape(final double width, final double height) {
        super(width, height);
        setStroke(Color.BLACK);
    }

    void setState(final State state) {
        Optional<Color> col = State.toColor(state);

        if (col.isPresent()) {
            setFill(col.get());
        }
    }
}
