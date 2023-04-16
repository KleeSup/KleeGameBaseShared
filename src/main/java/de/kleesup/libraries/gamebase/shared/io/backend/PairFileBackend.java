package de.kleesup.libraries.gamebase.shared.io.backend;

import de.kleesup.libraries.gamebase.shared.PairContainer;

import java.io.File;
import java.net.URI;

/**
 * A basement implementation of {@link FileBackend} which provides the ability to manage pair-data (key-value principle).
 * <br>Class created on 07.10.2022</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.0
 */
public abstract class PairFileBackend<K, V> extends FileBackend implements PairContainer<K, V> {

    public PairFileBackend(String pathname) {
        super(pathname);
    }

    public PairFileBackend(String parent, String child) {
        super(parent, child);
    }

    public PairFileBackend(File parent, String child) {
        super(parent, child);
    }

    public PairFileBackend(URI uri) {
        super(uri);
    }
}
