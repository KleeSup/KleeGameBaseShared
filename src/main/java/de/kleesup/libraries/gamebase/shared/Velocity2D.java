package de.kleesup.libraries.gamebase.shared;

import com.badlogic.gdx.math.Vector2;

/**
 * <br>Created on 19.10.2022</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public class Velocity2D extends Vector2 {

    public Velocity2D() {
    }

    public Velocity2D(float x, float y) {
        super(x, y);
    }

    public Velocity2D(Vector2 v) {
        super(v);
    }
}
