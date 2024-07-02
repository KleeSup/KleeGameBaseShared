package de.kleesup.libraries.gamebase.shared.world;

import de.kleesup.libraries.gamebase.shared.KleeUtil;

import java.util.concurrent.Future;

/**
 * @author KleeSup
 * @version 1.1
 * Class created on 08.10.2022
 * An implementation of {@link IChunkWorld3D} which is capable of loading and unloading chunks.
 * @since 1.0
 */
public interface ILoadableChunkWorld3D<Chunk extends IChunk3D> extends IChunkWorld3D<Chunk> {

    /**
     * Attempts to load a chunk at a given chunk coordinate.
     * @param chunkX The x-coordinate of the chunk.
     * @param chunkY The y-coordinate of the chunk.
     * @param chunkZ The z-coordinate of the chunk.
     * @return The chunk loader object (future) or a default value such as {@code null} (depends on implementation).
     */
    Future<Chunk> loadChunk(float chunkX, float chunkY, float chunkZ);

    /**
     * Tries to unload a chunk at a given coordinate.
     * @param chunkX The x-point of the chunks coordinate.
     * @param chunkY The y-point of the chunks coordinate.
     * @param chunkZ The z-point of the chunks coordinate.
     */
    void unloadChunk(float chunkX, float chunkY, float chunkZ);

    /**
     * Tries to unload a given loaded chunk.
     * @param chunk The loaded chunk object.
     * @throws IllegalArgumentException If the chunk is null or not from this world.
     */
    default void unloadChunk(Chunk chunk){
        KleeUtil.paramRequireNonNull(chunk, "Chunk cannot be null!");
        unloadChunk(chunk.getChunkX(), chunk.getChunkY(), chunk.getChunkZ());
    }

    /**
     * Checks whether a chunk at a given coordinate is loaded.
     * @param chunkX The x-point of the chunks coordinate.
     * @param chunkY The y-point of the chunks coordinate.
     * @return {@code true} if the chunk is loaded, {@code false} otherwise.
     */
    boolean isChunkLoaded(float chunkX, float chunkY, float chunkZ);
}
