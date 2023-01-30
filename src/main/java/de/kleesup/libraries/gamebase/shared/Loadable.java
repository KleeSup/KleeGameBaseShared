package de.kleesup.libraries.gamebase.shared;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * Simple interface which can be implemented into classes that need to load any kind of content at certain points (e.g. class construction).
 * @since 1.0
 */
public interface Loadable {

    void load();

    boolean isLoaded();

}
