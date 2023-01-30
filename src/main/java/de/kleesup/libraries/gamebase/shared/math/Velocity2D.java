package de.kleesup.libraries.gamebase.shared.math;

import com.badlogic.gdx.math.Vector2;

/**
 * A wrapper class of {@link Vector2} from LibGDX.
 * <br>Created on 30.01.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.3
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
