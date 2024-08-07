package de.kleesup.libraries.gamebase.shared.world;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022

 * An implementation of {@link IGameWorld} which is divided into chunks (2D grid system).
 * @since 1.0
 */
public interface IChunkWorld2D<Chunk extends IChunk2D> extends IGameWorld {

    /**
     * Returns the chunk at the given chunk-coordinate.
     * @param chunkX The chunks x-coordinate.
     * @param chunkY The chunks y-coordinate
     * @return The chunk at the given chunk-coordinate.
     */
    Chunk getChunk(float chunkX, float chunkY);

    /**
     * Returns the chunk at a given world-coordinate
     * @param x The x-value of the world coordinate.
     * @param y The y-value of the world coordinate.
     * @return The chunk at the given world-coordinate.
     */
    Chunk getChunkAt(float x, float y);

    /**
     * Checks whether the given coordinate is a valid chunk coordinate.
     * @param x The x-point of the coordinate.
     * @param y The y-point of the coordinate.
     * @return {@code true} if the coordinate is a valid chunk coordinate, {@code false} otherwise.
     */
    default boolean isValidChunkCoordinate(float x, float y){
        return (x % getChunkSizeX() == 0) && (y % getChunkSizeY() == 0);
    }

    /**
     * @return The chunks size on the x-axis.
     */
    float getChunkSizeX();

    /**
     * @return The chunks size on the y-axis.
     */
    float getChunkSizeY();

}
