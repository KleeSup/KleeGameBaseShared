package de.kleesup.libraries.gamebase.shared;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * Interface for updateable classes.
 * The {@link #update(long)} method uses a long parameter which determines the time that passed since the last time this
 * instance was updated (can be any valid tick time like millis).
 * @since 1.0
 */
public interface Updateable {

    /**
     * Updates the instance.
     * @param estimatedTime The estimated time since the last update was called (currently: in milliseconds).
     */
    void update(long estimatedTime);

}
