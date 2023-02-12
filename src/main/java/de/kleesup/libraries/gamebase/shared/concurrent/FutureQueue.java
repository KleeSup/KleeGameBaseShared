package de.kleesup.libraries.gamebase.shared.concurrent;

import de.kleesup.libraries.gamebase.shared.KleeUtil;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

/**
 * A small queue class which can hold multiple {@link Future} instances and also return the ones which are finished.
 * <br>Created on 02.02.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.4
 */
public class FutureQueue<T> {

    private final Collection<Future<T>> queue;
    public FutureQueue(Collection<Future<T>> queue){
        KleeUtil.paramRequireNonNull(queue, "Queue cannot be null!");
        this.queue = queue;
    }

    /**
     * Adds a new future to the queue.
     * @param future The future to add.
     */
    public void add(Future<T> future){
        KleeUtil.paramRequireNonNull(future, "Future cannot be null!");
        if(future.isDone())return;
        queue.add(future);
    }

    /**
     * Returns all futures of this queue which are finished.
     * @param finishedFuturesWriteTo A collection where the finished futures should be added to.
     * @param removeFinished Whether the finished futures should be removed from the queue.
     * @return A collection filled with all the finished futures of this queue.
     */
    public Collection<Future<T>> checkFinished(Collection<Future<T>> finishedFuturesWriteTo, boolean removeFinished){
        if(finishedFuturesWriteTo == null)finishedFuturesWriteTo = new LinkedList<>();
        Iterator<Future<T>> itr = queue.iterator();
        while (itr.hasNext()){
            Future<T> future = itr.next();
            if(future.isDone()){
                finishedFuturesWriteTo.add(future);
                if(removeFinished)itr.remove();
            }
        }
        return finishedFuturesWriteTo;
    }

    public Collection<Future<T>> checkFinished(boolean removeFinished){
        return checkFinished(null, removeFinished);
    }

    public Collection<Future<T>> getQueue(){
        return queue;
    }

}
