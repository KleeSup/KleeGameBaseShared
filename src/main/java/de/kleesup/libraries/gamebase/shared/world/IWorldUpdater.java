package de.kleesup.libraries.gamebase.shared.world;

import com.badlogic.gdx.Graphics;

/**
 * Used for objects that need updates via a {@link IGameWorld}.
 */
public interface IWorldUpdater {

    /**
     * The main update method.
     * @param world The world that manages the implementing object.
     * @param delta The time past since the last update.
     *              NOTE: This is not always the {@link Graphics#getDeltaTime()} because some objects might only
     *              get updated after some time periods.
     */
    void update(IGameWorld world, float delta);

}
