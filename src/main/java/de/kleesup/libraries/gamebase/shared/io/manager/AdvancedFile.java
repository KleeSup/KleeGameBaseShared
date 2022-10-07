package de.kleesup.libraries.gamebase.shared.io.manager;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * An advanced version of {@link File} with certain added features.
 * @since 1.0
 */
public class AdvancedFile extends File {

    public static final String CURRENT_PATH = ".";
    public static final String PATH_SEPARATOR = "/";

    public AdvancedFile(File file){
        super(file.getPath());
    }

    public AdvancedFile(String pathname) {
        super(pathname);
    }

    public AdvancedFile(String parent, String child) {
        super(parent, child);
    }

    public AdvancedFile(File parent, String child) {
        super(parent, child);
    }

    public AdvancedFile(URI uri) {
        super(uri);
    }

    @Override
    public boolean createNewFile() throws IOException {
        if(exists())return false;
        File parent = getParentFile();
        boolean success = parent.exists() || parent.mkdirs();
        return success && super.createNewFile();
    }


}
