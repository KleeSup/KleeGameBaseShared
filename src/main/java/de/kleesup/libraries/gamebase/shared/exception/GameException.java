package de.kleesup.libraries.gamebase.shared.exception;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 *
 * An exception that is thrown if game or API wise problems occur.
 * @since 1.0
 */
public class GameException extends RuntimeException {

    public GameException() {
    }

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameException(Throwable cause) {
        super(cause);
    }

    public GameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
