package de.kleesup.libraries.gamebase.shared.math.gdx;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * <br>Created on 16.04.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public class AABB2D extends AdvancedRectangle {

    public AABB2D() {
    }

    public AABB2D(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public AABB2D(Rectangle rect) {
        super(rect);
    }
}
