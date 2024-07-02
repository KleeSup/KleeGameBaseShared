package de.kleesup.libraries.gamebase.shared.world;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 * A class that is part of a {@link IChunkWorld2D} grid system.
 * It has a position and also a size given by the world it is bound to (See {@link IChunkWorld2D#getChunkSizeX()} and {@link IChunkWorld2D#getChunkSizeY()}).
 * @since 1.0
 */
public interface IChunk2D {

    /**
     * @return The x-point of the chunks coordinate.
     */
    float getChunkX();

    /**
     * @return The y-point of the chunks coordinate.
     */
    float getChunkY();

}
