package de.kleesup.libraries.gamebase.shared.world;

/**
 * An implementation of {@link IGameWorld} which is divided into chunks (3D grid system).
 * <br>Class created on 08.10.2022</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1
 */
public interface IChunkWorld3D<Chunk extends IChunk3D> extends IGameWorld {

    /**
     * Returns the chunk at the given coordinate.
     * @param chunkX The chunks x-coordinate.
     * @param chunkY The chunks y-coordinate.
     * @param chunkZ The chunks z-coordinate.
     * @return The chunk at the given coordinate.
     */
    Chunk getChunk(float chunkX, float chunkY, float chunkZ);

    /**
     * Returns the chunk at a given world-coordinate
     * @param x The x-value of the world coordinate.
     * @param y The y-value of the world coordinate.
     * @param z The z-value of the world coordinate.
     * @return The chunk at the given world-coordinate.
     */
    Chunk getChunkAt(float x, float y, float z);

    /**
     * Checks whether the given coordinate is a valid chunk coordinate.
     * @param x The x-point of the coordinate.
     * @param y The y-point of the coordinate.
     * @param z The z-point of the coordinate.
     * @return {@code true} if the coordinate is a valid chunk coordinate, {@code false} otherwise.
     */
    default boolean isValidChunkCoordinate(float x, float y, float z){
        return (x % getChunkSizeX() == 0) && (y % getChunkSizeY() == 0) && (z % getChunkSizeZ() == 0);
    }

    /**
     * @return The chunks size on the x-axis.
     */
    float getChunkSizeX();

    /**
     * @return The chunks size on the y-axis.
     */
    float getChunkSizeY();

    /**
     * @return The chunks size on the z-axis.
     */
    float getChunkSizeZ();

}
