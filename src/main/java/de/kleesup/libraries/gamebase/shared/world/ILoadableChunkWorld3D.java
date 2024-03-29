package de.kleesup.libraries.gamebase.shared.world;

import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.exception.GameException;

import java.util.concurrent.Future;

/**
 * @author KleeSup
 * @version 1.1
 * Class created on 08.10.2022
 *
 * An implementation of {@link IChunkWorld3D} which is capable of loading and unloading chunks.
 * @since 1.0
 */
public interface ILoadableChunkWorld3D extends IChunkWorld3D {

    /**
     * Attempts to load a chunk at a given chunk coordinate.
     * @param chunkX The x-coordinate of the chunk.
     * @param chunkY The y-coordinate of the chunk.
     * @param chunkZ The z-coordinate of the chunk.
     * @return The chunk loader object (future) or a default value such as {@code null} (depends on implementation).
     */
    Future<ILoadedChunk2D> loadChunk(float chunkX, float chunkY, float chunkZ);

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
    default void unloadChunk(ILoadedChunk3D chunk){
        KleeUtil.paramRequireNonNull(chunk, "Chunk cannot be null!");
        if(!this.equals(chunk.getWorld()))throw new IllegalArgumentException("World of the loaded chunk does not equal the world to unload it in.");
        unloadChunk(chunk.getChunkX(), chunk.getChunkY(), chunk.getChunkZ());
    }

    /**
     * Checks whether a chunk at a given coordinate is loaded.
     * @param chunkX The x-point of the chunks coordinate.
     * @param chunkY The y-point of the chunks coordinate.
     * @param chunkZ The z-point of the chunks coordinate.
     * @return {@code true} if the chunk is loaded, {@code false} otherwise.
     */
    boolean isChunkLoaded(float chunkX, float chunkY, float chunkZ);

    /**
     * Tries to return a loaded chunk object.
     * @param chunkX The x-coordinate of the chunk.
     * @param chunkY The y-coordinate of the chunk.
     * @param chunkZ The z-coordinate of the chunk.
     * @return The loaded chunk.
     * @throws GameException In case the chunk is not loaded.
     */
    default ILoadedChunk3D getChunkLoaded(float chunkX, float chunkY, float chunkZ){
        IChunk3D chunk = getChunk(chunkX, chunkY, chunkZ);
        if(!(chunk instanceof ILoadedChunk3D))throw new GameException("The chunk at "+chunkX+";"+chunkY+" is not loaded!");
        return (ILoadedChunk3D) chunk;
    }

}
