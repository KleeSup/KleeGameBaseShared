package de.kleesup.libraries.gamebase.shared.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * An enum class implementing all axis directions in a 2-dimensional and 3-dimensional space.
 * <br>Created on 03.02.2023</br>
 * @author KleeSup
 * @version 1.1
 * @since 1.1.4
 */
public enum Axis {

    X(1,0,0),
    Y(0,1,0),
    Z(0,0,1),
    NEGATIVE_X(-1, 0, 0),
    NEGATIVE_Y( 0,-1, 0),
    NEGATIVE_Z( 0, 0,-1);

    private final Vector3 dir;
    Axis(float x, float y, float z){
        this.dir = new Vector3(x, y, z);
    }

    public Axis inv(){
        switch (this){
            case X: return NEGATIVE_X;
            case Y: return NEGATIVE_Y;
            case Z: return NEGATIVE_Z;
            case NEGATIVE_X: return X;
            case NEGATIVE_Y: return Y;
            case NEGATIVE_Z: return Z;
        }
        return null;
    }

    public Vector3 getDirection() {
        return dir.cpy();
    }
}
