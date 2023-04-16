package de.kleesup.libraries.gamebase.shared.world;

/**
 * An interfaces which can be implemented into classes which can return a world object
 * (e.g. for entity-implementations which might return the world containing the entity).
 * <br>Created on 24.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public interface IWorldHolder<W extends IGameWorld> {
    W getWorld();

}
