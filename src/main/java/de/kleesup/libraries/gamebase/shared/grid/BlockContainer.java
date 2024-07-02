package de.kleesup.libraries.gamebase.shared.grid;

import com.badlogic.gdx.math.Vector3;
import de.kleesup.libraries.gamebase.shared.KleeUtil;

/**
 * An interfaces which creates the base for classes that are able to hold custom block objects in a 3D world.
 * <br>Created on 04.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public interface BlockContainer<B> {

    /**
     * Returns the block at a given position.
     * @param position The position of the wanted block.
     * @return The block at the given position.
     */
    default B getBlock(Vector3 position){
        KleeUtil.paramRequireNonNull(position, "Position cannot be null!");
        return getBlock(position.x,position.y,position.z);
    }

    /**
     * Returns the block at a given position.
     * @param x The x-coordinate of the wanted block.
     * @param y The y-coordinate of the wanted block.
     * @param z The z-coordinate of the wanted block.
     * @return The block at the given position.
     */
    B getBlock(float x, float y, float z);

    /**
     * Sets a block at a given position.
     * @param position The position to set the block at.
     * @param block The block to set.
     * @return The old block which was located at the given position, or a default value if there was no block before.
     */
    default B setBlock(Vector3 position, B block){
        KleeUtil.paramRequireNonNull(position, "Position cannot be null!");
        return setBlock(position.x,position.y,position.z,block);
    }

    /**
     * Sets a block at a given position.
     * @param x The x-coordinate of the block.
     * @param y The y-coordinate of the block.
     * @param z The z-coordinate of the block.
     * @param block The block to set.
     * @return The old block which was located at the given position, or a default value if there was no block before.
     */
    B setBlock(float x, float y, float z, B block);

    /**
     * Checks whether a given position has a block set.
     * @param x The x-coordinate of the block.
     * @param y The y-coordinate of the block.
     * @param z The z-coordinate of the block.
     * @return {@code true} if a block at the given positions exists, {@code false} otherwise.
     */
    boolean hasBlock(float x, float y, float z);

}
