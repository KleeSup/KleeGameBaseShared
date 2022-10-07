package de.kleesup.libraries.gamebase.shared.io.backend;

import de.kleesup.libraries.gamebase.shared.ObjectDisposable;
import de.kleesup.libraries.gamebase.shared.io.manager.AdvancedFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * A basement class for data management with files.
 */
public class FileBackend extends AdvancedFile implements ObjectDisposable {
    public FileBackend(String pathname) {
        super(pathname);
    }

    public FileBackend(String parent, String child) {
        super(parent, child);
    }

    public FileBackend(File parent, String child) {
        super(parent, child);
    }

    public FileBackend(URI uri) {
        super(uri);
    }

    /**
     * Saves all cached data.
     * Can be overridden.
     */
    public void save() throws IOException {
        if(!exists())createNewFile();
    }

    /**
     * Used for disposing cached data when the application gets closed.
     * Can be overridden.
     */
    @Override
    public void dispose() {

    }

}
