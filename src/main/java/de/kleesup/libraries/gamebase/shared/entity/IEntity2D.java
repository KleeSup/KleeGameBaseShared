package de.kleesup.libraries.gamebase.shared.entity;

import com.badlogic.gdx.utils.Disposable;
import de.kleesup.libraries.gamebase.shared.Identifiable;
import de.kleesup.libraries.gamebase.shared.math.gdx.AABB2D;
import de.kleesup.libraries.gamebase.shared.world.IDynamicWorldObject2D;
import de.kleesup.libraries.gamebase.shared.world.IGameWorld;
import de.kleesup.libraries.gamebase.shared.world.IWorldHolder;

/**
 * A simple base class for entity implementations.
 * <br>Created on 20.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public interface IEntity2D<I, W extends IGameWorld> extends IDynamicWorldObject2D, Identifiable<I>, Disposable, IWorldHolder<W> {

    AABB2D getBoundingBox();

    default void kill(){
        dispose();
    }
    default void remove(){
        dispose();
    }

}
