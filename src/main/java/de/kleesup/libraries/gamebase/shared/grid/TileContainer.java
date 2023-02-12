package de.kleesup.libraries.gamebase.shared.grid;

import com.badlogic.gdx.math.Vector2;
import de.kleesup.libraries.gamebase.shared.KleeUtil;

/**
 * An interfaces which creates the base for classes that are able to hold custom tile objects in a tiled world.
 * <br>Created on 04.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public interface TileContainer<T> {

    /**
     * Returns the tile at a given position.
     * @param position The position of the wanted tile.
     * @return The tile at the given position.
     */
    default T getTile(Vector2 position){
        KleeUtil.paramRequireNonNull(position, "Position cannot be null!");
        return getTile(position.x, position.y);
    }

    /**
     * Returns the tile at a given position.
     * @param x The x-coordinate of the wanted tile.
     * @param y The y-coordinate of the wanted tile.
     * @return The tile at the given position.
     */
    T getTile(float x, float y);

    /**
     * Sets a tile at a given position.
     * @param position The position to set the tile at.
     * @param tile The tile to set.
     * @return The old tile which was located at the given position, or a default value if there was no tile before.
     */
    default T setTile(Vector2 position, T tile){
        KleeUtil.paramRequireNonNull(position, "Position cannot be null!");
        return setTile(position.x, position.y, tile);
    }

    /**
     * Sets a tile at a given position.
     * @param x The x-coordinate of the tile to set.
     * @param y The y-coordinate of the tile to set.
     * @param tile The tile to set.
     * @return The old tile which was located at the given position, or a default value if there was no tile before.
     */
    T setTile(float x, float y, T tile);



}
