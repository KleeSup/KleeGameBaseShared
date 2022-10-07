package de.kleesup.libraries.gamebase.shared;

import de.kleesup.libraries.gamebase.shared.annotation.Beta;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * A class that handles cooldowns easily. (Should be multi-threaded)
 * @since 1.0
 */
@Beta
public class Timer {

    private final Object block = new Object(); //using a block object for blocking all available methods of this class when one of them is invoked.
    private final AtomicBoolean stopped = new AtomicBoolean(true);
    private final AtomicLong endPoint = new AtomicLong(0);
    private final AtomicLong currentTime = new AtomicLong(0);
    private volatile TimeUnit currentTimeUnit = TimeUnit.MILLISECONDS;
    public Timer(){}

    /**
     * @return {@code true} if the timer is currently running, {@code false} otherwise.
     */
    public boolean isRunning(){
        boolean stop = stopped.get();
        if(stop)return false;
        if(System.currentTimeMillis() <= endPoint.get()){
            stopped.set(true);
            return false;
        }
        return true;
    }

    /**
     * Starts a new cooldown for this timer instance.
     * @param time The time span of the cooldown.
     * @param timeUnit The unit in which the time is measured.
     */
    public void start(final long time, final TimeUnit timeUnit){
        synchronized (block){
            stopped.set(false);
            endPoint.set(System.currentTimeMillis() + timeUnit.toMillis(time));
            currentTime.set(time);
            currentTimeUnit = timeUnit;
        }
    }

    /**
     * Stops the currently running timer.
     */
    public void stop(){
        synchronized (block){
            stopped.set(true);
        }
    }

    /**
     * @return the current time to wait (or the last one, if no timer is currently running).
     */
    public long getCurrentTime() {
        return currentTime.get();
    }

    /**
     * @return the current time unit (or the last one, if no timer is currently running).
     */
    public TimeUnit getCurrentTimeUnit() {
        return currentTimeUnit;
    }
}
