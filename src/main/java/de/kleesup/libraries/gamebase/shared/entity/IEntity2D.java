package de.kleesup.libraries.gamebase.shared.entity;

import de.kleesup.libraries.gamebase.shared.Updateable;
import de.kleesup.libraries.gamebase.shared.world.IDynamicWorldObject2D;
import de.kleesup.libraries.gamebase.shared.world.IGameWorld;

public interface IEntity2D<Id, World extends IGameWorld> extends IDynamicWorldObject2D<Id>, Updateable {

    void kill(World world);

}
