package de.kleesup.libraries.gamebase.shared.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * A {@link Future} which holds the wanted object since its creation.
 * <br>Created on 02.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public class InstantFuture<T> implements Future<T> {

    private final T obj;
    public InstantFuture(T obj){
        this.obj = obj;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return obj;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return obj;
    }
}
