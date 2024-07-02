package de.kleesup.libraries.gamebase.shared;

/**
 * Interface for classes that can receive (timed) updates.
 * @since 1.0
 * @author KleeSup
 * @version 1.2
 */
public interface Updateable {

    /**
     * Updates the instance.
     * @param delta The time between the last update and now in seconds.
     */
    void update(float delta);

}
