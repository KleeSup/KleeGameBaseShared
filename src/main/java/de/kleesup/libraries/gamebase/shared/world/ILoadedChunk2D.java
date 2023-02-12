package de.kleesup.libraries.gamebase.shared.world;

import de.kleesup.libraries.gamebase.shared.Loadable;

/**
 * An implementation of {@link IChunk2D} that represents a chunk object that is required to be loaded.
 * <br>Class created on 08.10.2022</br>
 * @author KleeSup
 * @version 1.1
 * @since 1.0
 */
public interface ILoadedChunk2D extends IChunk2D {

    /**
     * Checks whether this chunk is loaded in its world.
     * @return {@code true} if the chunk is loaded, {@code false} otherwise.
     */
    default boolean isLoaded(){
        return getWorld().isChunkLoaded(getChunkX(), getChunkY());
    }

    @Override
    ILoadableChunkWorld2D getWorld();

}
