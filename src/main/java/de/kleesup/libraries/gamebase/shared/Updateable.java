package de.kleesup.libraries.gamebase.shared;

import java.util.concurrent.TimeUnit;

/**
 * @author KleeSup
 * @version 1.1
 * Class created on 07.10.2022
 *
 * Interface for classes that can receive (timed) updates.
 * The {@link #update(long, TimeUnit)} method uses a long parameter which determines the time that passed since the last time this
 * instance was updated. To determine the unit of the estimated time, a {@link TimeUnit} is required.
 * @since 1.0
 */
public interface Updateable {

    /**
     * Updates the instance.
     * @param estimatedTime The estimated time since the last update was called.
     * @param unit The unit of the estimated time.
     */
    void update(long estimatedTime, TimeUnit unit);

}
