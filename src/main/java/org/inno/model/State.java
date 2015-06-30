package org.inno.model;

import javafx.scene.paint.Color;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;


/**
 * State of the technology.
 *
 * @author spindizzy
 */
public enum State {
    None, Green, Yellow, Red;

    private static final Map<State, Color> ENUM_MAP = new EnumMap<>(State.class);

    static {
        ENUM_MAP.put(State.None, null);
        ENUM_MAP.put(State.Red, Color.RED);
        ENUM_MAP.put(State.Yellow, Color.YELLOW);
        ENUM_MAP.put(State.Green, Color.GREEN);
    }

    public static Optional<Color> toColor(final State state) {
        Color col = ENUM_MAP.get(state);

        return (col != null) ? of(col) : empty();
    }
}
