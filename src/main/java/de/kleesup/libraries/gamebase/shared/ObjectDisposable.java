package de.kleesup.libraries.gamebase.shared;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * Interfaces which can be implemented in classes that need to clear objects after certain tasks where finished or when the
 * program is about to shut down.
 * @since 1.0
 */
public interface ObjectDisposable {

    /**
     * Called from outside when the implementing class needs to clear up objects.
     */
    void dispose();

}
