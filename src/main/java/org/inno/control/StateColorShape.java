package org.inno.control;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.inno.model.State;

/**
 * Shape for the {@link State}
 * @author spindizzy
 */
class StateColorShape extends Rectangle{

    StateColorShape() {
        this(20, 10);
    }
    
    StateColorShape(double width, double height) {
        super(width, height);
        setStroke(Color.BLACK);
    }
    
    void setState(State state){
       setFill(State.toColor(state)); 
    }
}
