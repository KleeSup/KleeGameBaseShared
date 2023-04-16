package de.kleesup.libraries.gamebase.shared.entity;

import com.badlogic.gdx.utils.Disposable;
import de.kleesup.libraries.gamebase.shared.Identifiable;
import de.kleesup.libraries.gamebase.shared.math.AABB3D;
import de.kleesup.libraries.gamebase.shared.world.IDynamicWorldObject3D;
import de.kleesup.libraries.gamebase.shared.world.IGameWorld;
import de.kleesup.libraries.gamebase.shared.world.IWorldHolder;

/**
 * A simple base class for entity implementations.
 * <br>Created on 28.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public interface IEntity3D<I, W extends IGameWorld> extends IDynamicWorldObject3D, Identifiable<I>, Disposable, IWorldHolder<W> {

    AABB3D getBoundingBox();

    default void kill(){
        dispose();
    }
    default void remove(){
        dispose();
    }

}
