package de.kleesup.libraries.gamebase.shared.world;

import de.kleesup.libraries.gamebase.shared.Velocity2D;

/**
 * <br>Created on 19.10.2022</br>
 * A {@link IWorldObject2D} which implements functions to move it in a world.
 * It can be teleported directly or physical calculations can be applied to its {@link Velocity2D}
 * which then requires an implementation for moving this object based on its velocity.
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public interface IDynamicWorldObject2D extends IWorldObject2D {

    /**
     * Moves this object to a given coordinate.
     * @param x The x-point of the new coordinate.
     * @param y The y-point of the new coordinate.
     */
    default void teleport(float x, float y){
        setX(x);
        setY(y);
    }

    /**
     * Applies a linear velocity value to this dynamic objects velocity.
     * @param velocityX The x-value of the velocity to apply.
     * @param velocityY The y-value of the velocity to apply.
     */
    default void applyLinearVelocity(float velocityX, float velocityY){
        getVelocity().add(velocityX, velocityY);
    }

    /*
    Setter
    */

    void setX(float x);
    void setY(float y);

    /*
    Getter
    */

    Velocity2D getVelocity();

}
