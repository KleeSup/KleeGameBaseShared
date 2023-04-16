package de.kleesup.libraries.gamebase.shared.io.backend;

import com.badlogic.gdx.utils.Disposable;
import de.kleesup.libraries.gamebase.shared.io.manager.AdvancedFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * A basement class for data management with files.
 * <br>Class created on 07.10.2022</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.0
 */
public class FileBackend extends AdvancedFile implements Disposable {
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
