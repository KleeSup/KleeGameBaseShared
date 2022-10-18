package de.kleesup.libraries.gamebase.shared;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 17.10.2022
 *
 * An interface that can be used to build certain objects.
 * @since 1.0
 */
public interface Builder<R> {

    /**
     * Builds a specific object.
     * @return The build object.
     */
    R build();

}
