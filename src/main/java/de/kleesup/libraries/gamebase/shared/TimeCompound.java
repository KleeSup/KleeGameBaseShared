package de.kleesup.libraries.gamebase.shared;

import java.util.concurrent.TimeUnit;

/**
 * A compound of a {@link TimeUnit} and a long-value that refers to the time.
 * <br>Created on 22.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.5
 */
public class TimeCompound {

    private final TimeUnit unit;
    private final long value;
    public TimeCompound(TimeUnit unit, long value){
        KleeUtil.paramRequireNonNull(unit, "TimeUnit cannot be null!");
        this.unit = unit;
        this.value = value;
    }

    public long convert(TimeUnit otherUnit){
        return otherUnit.convert(value, unit);
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public long getValue() {
        return value;
    }
}
