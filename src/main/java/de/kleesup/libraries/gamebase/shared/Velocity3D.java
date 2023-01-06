package de.kleesup.libraries.gamebase.shared;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * <br>Created on 19.10.2022</br>
 *
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public class Velocity3D extends Vector3 {

    public Velocity3D() {
    }

    public Velocity3D(float x, float y, float z) {
        super(x, y, z);
    }

    public Velocity3D(Vector3 vector) {
        super(vector);
    }

    public Velocity3D(float[] values) {
        super(values);
    }

    public Velocity3D(Vector2 vector, float z) {
        super(vector, z);
    }
}
