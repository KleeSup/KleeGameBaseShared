package de.kleesup.libraries.gamebase.shared.world;

import com.badlogic.gdx.math.Vector2;
import de.kleesup.libraries.gamebase.shared.KleeUtil;

/**
 * <br>Created on 19.10.2022</br>
 * A {@link IWorldObject2D} which implements functions to move it in a world.
 * It can be teleported directly or physical calculations can be applied to its {@link Vector2}
 * which then requires an implementation for moving this object based on its velocity.
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public interface IDynamicWorldObject2D<Id> extends IWorldObject2D<Id> {

    /**
     * Teleports this object to a given coordinate.
     * @param x The x-point of the new coordinate.
     * @param y The y-point of the new coordinate.
     */
    default void teleport(float x, float y){
        setX(x);
        setY(y);
    }

    /**
     * Moves this object by given values.
     * @param x The x-value to move.
     * @param y The y-value to move.
     */
    default void translate(float x, float y){
        setX(getX() + x);
        setY(getY() + y);
    }

    /**
     * Applies a linear velocity value to this dynamic objects velocity.
     * @param velocityX The x-value of the velocity to apply.
     * @param velocityY The y-value of the velocity to apply.
     */
    default void applyLinearVelocity(float velocityX, float velocityY){
        getVelocity().add(velocityX, velocityY);
    }

    default void applyLinearVelocity(Vector2 velocity){
        KleeUtil.paramRequireNonNull(velocity, "Velocity cannot be null!");
        applyLinearVelocity(velocity.x, velocity.y);
    }

    /*
    Setter
    */

    void setX(float x);
    void setY(float y);

    /*
    Getter
    */

    Vector2 getVelocity();

}
