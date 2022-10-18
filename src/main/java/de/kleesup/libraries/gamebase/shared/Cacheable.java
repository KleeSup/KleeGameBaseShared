package de.kleesup.libraries.gamebase.shared;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 17.10.2022
 *
 * An interface that can be implemented into objects that can be put in any type of caching system.
 * @since 1.0
 */
public interface Cacheable {

    /**
     * Determines if the cached object is still required to be in cache.
     * @return {@code true} if this objects still needs to be in some sort of cache, {@code false} otherwise.
     */
    boolean stillRequired();

}
