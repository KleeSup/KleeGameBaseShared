package de.kleesup.libraries.gamebase.shared.world;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 * A class that is part of a {@link IChunkWorld3D} grid system.
 * It has a position and also a size given by the world it is bound to (See {@link IChunkWorld3D#getChunkSizeX()},
 *  {@link IChunkWorld3D#getChunkSizeY()} and {@link IChunkWorld3D#getChunkSizeZ()}).
 * @since 1.0
 */
public interface IChunk3D {

    /**
     * @return The x-point of the chunks coordinate.
     */
    float getChunkX();

    /**
     * @return The y-point of the chunks coordinate.
     */
    float getChunkY();

    /**
     * @return The z-point of the chunks coordinate.
     */
    float getChunkZ();

    /**
     * @return The world containing this chunk object.
     */
    IChunkWorld3D getWorld();
}
