package de.kleesup.libraries.gamebase.shared.io.backend;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.kryo.KryoUtil;

import java.io.*;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A file backend that uses a {@link Kryo} instance to serialize the written data (in pair format) into the file.
 * <br>Class created on 07.10.2022</br>
 * @author KleeSup
 * @version 1.1
 * @since 1.0
 */
public class KryoFileBackend extends PairFileBackend<Object, Object> {

    private static final MapSerializer<ConcurrentHashMap<Object, Object>> serializer = new MapSerializer<>();
    static {
        serializer.setKeyClass(Object.class);
        serializer.setKeysCanBeNull(false);
        serializer.setValueClass(Object.class);
    }

    private final Kryo kryo;
    private final ConcurrentHashMap<Object, Object> root = new ConcurrentHashMap<>();

    public KryoFileBackend(String pathname, Kryo kryo) throws IOException {
        super(pathname);
        this.kryo = kryo;
        init(kryo);
    }

    public KryoFileBackend(String parent, String child, Kryo kryo) throws IOException {
        super(parent, child);
        this.kryo = kryo;
        init(kryo);
    }

    public KryoFileBackend(File parent, String child, Kryo kryo) throws IOException {
        super(parent, child);
        this.kryo = kryo;
        init(kryo);
    }

    public KryoFileBackend(URI uri, Kryo kryo) throws IOException {
        super(uri);
        this.kryo = kryo;
        init(kryo);
    }


    private void init(final Kryo kryo) throws IOException {
        if(kryo == null)throw new NullPointerException("Kryo cannot be null!");
        if(!KryoUtil.isClassRegistered(ConcurrentHashMap.class, kryo)){
            kryo.register(ConcurrentHashMap.class, serializer);
        }
        if(!exists())return;
        //start loading
        final Input input = new Input(new FileInputStream(this));
        if(input.available() == 0)return; //if empty -> causes underflow exception

        final ConcurrentHashMap<?,?> map = kryo.readObjectOrNull(input, ConcurrentHashMap.class, serializer);
        if(map != null)root.putAll(map);
        input.close();
    }

    @Override
    public void save() throws IOException {
        super.save();
        try {
            final Output output = new Output(new FileOutputStream(this));
            kryo.writeObject(output, root, serializer);
            output.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean has(Object key) {
        return root.containsKey(key);
    }

    @Override
    public Object set(Object key, Object value) {
        if(value == null){
            return root.remove(key);
        }
        return root.put(key,value);
    }

    @Deprecated
    public Object registerAndSet(final Object key, final Object value){
        KleeUtil.paramRequireNonNull(key, "Key cannot be null");
        if(!KryoUtil.isClassRegistered(key.getClass(),kryo))kryo.register(key.getClass());
        if(value != null && !KryoUtil.isClassRegistered(value.getClass(),kryo))kryo.register(value.getClass());
        return root.put(key,value);
    }

    @Override
    public Object get(Object key) {
        return root.get(key);
    }

    @Override
    public Object remove(Object key) {
        return root.remove(key);
    }

}
