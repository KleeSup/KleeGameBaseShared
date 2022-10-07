package de.kleesup.libraries.gamebase.shared.io.backend;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * An implementation of {@link FileBackendWriter} to write plain text into files.
 * @since 1.0
 */
public class TextFileWriter extends FileBackendWriter<String> {

    protected PrintWriter printWriter;

    public TextFileWriter(String pathname) throws IOException {
        super(pathname);
        createWriter();
    }

    public TextFileWriter(String parent, String child) throws IOException {
        super(parent, child);
        createWriter();
    }

    public TextFileWriter(File parent, String child) throws IOException {
        super(parent, child);
        createWriter();
    }

    public TextFileWriter(URI uri) throws IOException {
        super(uri);
        createWriter();
    }


    private void createWriter() throws IOException {
        super.save(); //create the file first.
        if(printWriter == null)printWriter = new PrintWriter(this);
    }

    @Override
    public void save() throws IOException {
        super.save();
        printWriter.flush();
    }

    @Override
    public void write(String value) {
        printWriter.println(value);
    }

    @Override
    public void dispose() {
        printWriter.close();
    }

}
