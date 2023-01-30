package de.kleesup.libraries.gamebase.shared.log;

/**
 * @author KleeSup
 * @version 1.1
 * Class created on 07.10.2022
 *
 * Simple logger interface which is capable of logging the following tags:
 * - INFO
 * - WARN
 * - ERROR
 * - DEBUG
 * @since 1.0
 */
public interface ILogger {

    String INFO = "INFO";
    String WARN = "WARN";
    String ERROR = "ERROR";
    String DEBUG = "DEBUG";

    static String toTag(final String innerTagValue){
        return "[" + innerTagValue +"]";
    }

    void logInfo(final String msg);
    void logWarning(final String msg);
    void logWarning(final String msg, final Throwable throwable);
    void logError(final String msg);
    void logError(final String msg, final Throwable throwable);
    void logDebug(final String msg);
    void logDebug(final String msg, final Throwable throwable);

}
