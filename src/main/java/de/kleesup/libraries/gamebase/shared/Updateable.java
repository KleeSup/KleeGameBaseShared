package de.kleesup.libraries.gamebase.shared;

import java.util.concurrent.TimeUnit;

/**
 * Interface for classes that can receive (timed) updates.
 * The {@link #update(long, TimeUnit)} method uses a long parameter which determines the time that passed since the last time this
 * instance was updated. To determine the unit of the estimated time, a {@link TimeUnit} is required.
 * <br>Class created on 07.10.2022</br>
 * @since 1.0
 * @author KleeSup
 * @version 1.2
 */
public interface Updateable {

    /**
     * Returns the time in any desired TimeUnit between a specific timestamp and now.
     * @param lastTimeStamp The timestamp to get the time in between.
     * @param inputUnit The unit the timestamp is in.
     * @param outputUnit The unit for the output.
     * @return The translated time in between of the given timestamp and now.
     */
    static long calculateEstimatedTime(long lastTimeStamp, TimeUnit inputUnit, TimeUnit outputUnit){
        long timeMillis = System.currentTimeMillis() - inputUnit.toMillis(lastTimeStamp);
        return outputUnit.convert(timeMillis, TimeUnit.MILLISECONDS);
    }
    static long calculateEstimatedTime(long lastTimeStamp, TimeUnit inputUnit){
        return calculateEstimatedTime(lastTimeStamp, inputUnit, inputUnit);
    }

    /**
     * Updates the instance.
     * @param estimatedTime The estimated time since the last update was called.
     * @param unit The unit of the estimated time.
     */
    void update(long estimatedTime, TimeUnit unit);

}
