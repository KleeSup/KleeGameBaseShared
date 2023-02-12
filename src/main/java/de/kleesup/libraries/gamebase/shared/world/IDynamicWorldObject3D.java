package de.kleesup.libraries.gamebase.shared.world;

import com.badlogic.gdx.math.Vector3;
import de.kleesup.libraries.gamebase.shared.KleeUtil;

/**
 * <br>Created on 19.10.2022</br>
 * A {@link IWorldObject3D} which implements functions to move it in a world.
 * It can be teleported directly or physical calculations can be applied to its {@link Vector3}
 * which then requires an implementation for moving this object based on its velocity.
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public interface IDynamicWorldObject3D extends IWorldObject3D {

    /**
     * Moves this object to a given coordinate.
     * @param x The x-point of the new coordinate.
     * @param y The y-point of the new coordinate.
     */
    default void teleport(float x, float y, float z){
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * Applies a linear velocity value to this dynamic objects velocity.
     * @param velocityX The x-value of the velocity to apply.
     * @param velocityY The y-value of the velocity to apply.
     */
    default void applyLinearVelocity(float velocityX, float velocityY, float velocityZ){
        getVelocity().add(velocityX, velocityY, velocityZ);
    }

    default void applyLinearVelocity(Vector3 velocity){
        KleeUtil.paramRequireNonNull(velocity, "Velocity cannot be null!");
        applyLinearVelocity(velocity.x, velocity.y, velocity.z);
    }

    /*
    Setter
     */

    void setX(float x);
    void setY(float y);
    void setZ(float z);

    /*
    Getter
     */

    Vector3 getVelocity();

}
