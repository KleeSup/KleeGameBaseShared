package de.kleesup.libraries.gamebase.shared.io.backend;

import java.io.File;
import java.net.URI;

/**
 * Basement class for writing single values into file backends.
 * <br>Class created on 12.05.2022</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.0
 */
public abstract class FileBackendWriter<T> extends FileBackend {

    public FileBackendWriter(String pathname) {
        super(pathname);
    }

    public FileBackendWriter(String parent, String child) {
        super(parent, child);
    }

    public FileBackendWriter(File parent, String child) {
        super(parent, child);
    }

    public FileBackendWriter(URI uri) {
        super(uri);
    }

    public abstract void write(T value);

}
