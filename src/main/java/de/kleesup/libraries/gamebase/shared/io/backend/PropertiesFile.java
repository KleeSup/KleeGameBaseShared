package de.kleesup.libraries.gamebase.shared.io.backend;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

/**
 *
 * Implementation of {@link PairFileBackend} which manages Javas properties files.
 * <br>Reference: <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Properties.html">https://docs.oracle.com/javase/7/docs/api/java/util/Properties.html</a></br>
 * <br>Class created on 07.10.2022</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.0
 */
public class PropertiesFile extends PairFileBackend<Object, Object> {

    private final Properties properties;
    private String comments = null;

    public PropertiesFile(String pathname) throws IOException {
        super(pathname);
        this.properties = new Properties();
        load();
    }

    public PropertiesFile(String parent, String child) throws IOException {
        super(parent, child);
        this.properties = new Properties();
        load();
    }

    public PropertiesFile(File parent, String child) throws IOException {
        super(parent, child);
        this.properties = new Properties();
        load();
    }

    public PropertiesFile(URI uri) throws IOException {
        super(uri);
        this.properties = new Properties();
        load();
    }

    private void load() throws IOException {
        if(!exists())return;
        FileInputStream input = new FileInputStream(this);
        properties.load(input);
        input.close();
    }

    @Override
    public void save() throws IOException {
        super.save();
        final FileWriter writer = new FileWriter(this);
        properties.store(writer, comments);
        writer.close();
    }


    @Override
    public boolean has(Object key) {
        return properties.containsKey(key);
    }

    @Override
    public Object set(Object key, Object newValue) {
        return properties.put(key, newValue);
    }

    @Override
    public Object get(Object key) {
        return properties.get(key);
    }

    @Override
    public Object remove(Object key) {
        return properties.remove(key);
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Properties getProperties() {
        return properties;
    }
}
