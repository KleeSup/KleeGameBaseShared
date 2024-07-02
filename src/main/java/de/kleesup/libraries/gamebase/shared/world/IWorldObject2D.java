package de.kleesup.libraries.gamebase.shared.world;

import de.kleesup.libraries.gamebase.shared.Identifiable;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 * An interfaces for objects that can be added into a 2d game world.
 * @since 1.0
 */
public interface IWorldObject2D<Id> extends Identifiable<Id> {

    float getX();
    float getY();

}
