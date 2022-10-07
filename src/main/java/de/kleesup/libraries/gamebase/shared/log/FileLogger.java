package de.kleesup.libraries.gamebase.shared.log;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * Simple implementation of {@link ILogger} which can be used for saving logs into files.
 * @since 1.0
 */
public interface FileLogger extends ILogger {

    /**
     * Saves the log in memory to the file.
     */
    void saveLog();

}
