package org.inno.model;

import java.util.EnumMap;
import java.util.Map;
import javafx.scene.paint.Color;

/**
 * State of the technology.
 * 
 * @author spindizzy
 */
public enum State {
    Green, Yellow, Red;

    private static final Map<State, Color> ENUM_MAP = new EnumMap<>(State.class);
    
    static {
        ENUM_MAP.put(State.Red, Color.RED);
        ENUM_MAP.put(State.Yellow, Color.YELLOW);
        ENUM_MAP.put(State.Green, Color.GREEN);
    }
    
    public static Color toColor(State state){
        return ENUM_MAP.get(state);
    }
}
