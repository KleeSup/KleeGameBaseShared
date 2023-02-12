package de.kleesup.libraries.gamebase.shared.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * <br>Created on 03.02.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public enum AxisDirection {

    X(1,0,0),
    Y(0,1,0),
    Z(0,0,1),
    NEGATIVE_X(-1,0,0),
    NEGATIVE_Y(0,-1,0),
    NEGATIVE_Z(0,0,-1),

    ;

    private final float xMul, yMul, zMul;
    AxisDirection(float xMul, float yMul, float zMul){
        this.xMul = xMul;
        this.yMul = yMul;
        this.zMul = zMul;

    }

    public Vector3 addInDirection(Vector3 vector, float value){
        return vector.add(value * xMul, value * yMul, value * zMul);
    }

    public Vector2 addInDirection(Vector2 vector, float value){
        if(this == Z || this == NEGATIVE_Z)throw new UnsupportedOperationException("Cannot add a third coordinate value to a 2D Vector!");
        return vector.add(value * xMul, value * yMul);
    }


}
