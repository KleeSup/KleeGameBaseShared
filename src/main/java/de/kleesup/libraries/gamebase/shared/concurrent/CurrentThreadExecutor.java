package de.kleesup.libraries.gamebase.shared.concurrent;

import java.util.concurrent.Executor;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 08.10.2022
 *
 * An implementation of {@link Executor} which executes tasks on the current thread.
 * @since 1.0
 */
public class CurrentThreadExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
