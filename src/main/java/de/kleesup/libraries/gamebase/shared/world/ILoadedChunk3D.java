package de.kleesup.libraries.gamebase.shared.world;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 *
 * An implementation of {@link IChunk3D} that represents a chunk object that is required to be loaded.
 * @since 1.0
 */
public interface ILoadedChunk3D extends IChunk3D {

    /**
     * Checks whether this chunk is loaded in its world.
     * @return {@code true} if the chunk is loaded, {@code false} otherwise.
     */
    default boolean isLoaded(){
        return getWorld().isChunkLoaded(getChunkX(), getChunkY(), getChunkZ());
    }

    @Override
    ILoadableChunkWorld3D getWorld();

}
