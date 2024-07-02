package de.kleesup.libraries.gamebase.shared.world;

import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.exception.GameException;

import java.util.concurrent.Future;

/**
 * An implementation of {@link IChunkWorld2D} which is capable of loading and unloading chunks.
 * <br>Class created on 08.10.2022</br>
 * @author KleeSup
 * @version 1.2
 * @since 1.0
 */
public interface ILoadableChunkWorld2D<Chunk extends IChunk2D> extends IChunkWorld2D<Chunk> {

    /**
     * Attempts to load a chunk at a given chunk coordinate.
     * @param chunkX The x-coordinate of the chunk.
     * @param chunkY The y-coordinate of the chunk.
     * @return The chunk loader object (future) or a default value such as {@code null} (depends on implementation).
     */
    Future<Chunk> loadChunk(float chunkX, float chunkY);

    /**
     * Tries to unload a chunk at a given coordinate.
     * @param chunkX The x-point of the chunks coordinate.
     * @param chunkY The y-point of the chunks coordinate.
     */
    void unloadChunk(float chunkX, float chunkY);

    /**
     * Tries to unload a given loaded chunk.
     * @param chunk The loaded chunk object.
     * @throws IllegalArgumentException If the chunk is null or not from this world.
     */
    default void unloadChunk(Chunk chunk){
        KleeUtil.paramRequireNonNull(chunk, "Chunk cannot be null!");
        unloadChunk(chunk.getChunkX(), chunk.getChunkY());
    }

    /**
     * Checks whether a chunk at a given coordinate is loaded.
     * @param chunkX The x-point of the chunks coordinate.
     * @param chunkY The y-point of the chunks coordinate.
     * @return {@code true} if the chunk is loaded, {@code false} otherwise.
     */
    boolean isChunkLoaded(float chunkX, float chunkY);

}
