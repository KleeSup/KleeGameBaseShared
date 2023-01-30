package de.kleesup.libraries.gamebase.shared.world;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 *
 * A world that is sized by min and max x, y and z coordinates.
 * @since 1.0
 */
public interface ISizedWorld3D extends IGameWorld {

    /**
     * Checks whether a coordinate is in bounds of this worlds size.
     * @param x The x-point of the coordinate.
     * @param y The y-point of the coordinate.
     * @param z The z-point of the coordinate.
     * @return {@code true} if the coordinate is in bounds of this world, {@code false} otherwise.
     */
    default boolean inBounds(float x, float y, float z){
        return (x >= getMinWorldX() && x < getMaxWorldX()) && (y >= getMinWorldY() && y < getMaxWorldY()) &&
                (z >= getMinWorldZ() && z < getMaxWorldZ());
    }

    /**
     * @return The maximum x-point of the world.
     */
    float getMaxWorldX();

    /**
     * @return The maximum y-point of the world.
     */
    float getMaxWorldY();

    /**
     * @return The minimum x-point of the world.
     */
    float getMinWorldX();

    /**
     * @return The minimum y-point of the world.
     */
    float getMinWorldY();

    /**
     * @return The minimum z-point of the world.
     */
    float getMinWorldZ();

    /**
     * @return The maximum z-point of the world.
     */
    float getMaxWorldZ();

}
