package de.kleesup.libraries.gamebase.shared.collection;

/**
 * <br>Created on 06.01.2023</br>
 *
 * @author KleeSup
 * @version 1.0
 */
public class ConcurrentArray<T> extends WrappedArray<T> {
    public ConcurrentArray(T[] elements) {
        super(null);

    }

    public ConcurrentArray(Class<T> clazz, int capacity) {
        super(clazz, capacity);
    }

    public ConcurrentArray(int capacity) {
        super(capacity);
    }
}
