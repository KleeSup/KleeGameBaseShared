package de.kleesup.libraries.gamebase.shared.collection;

import de.kleesup.libraries.gamebase.shared.KleeUtil;

import java.util.*;
import java.util.function.Supplier;

/**
 * A map that manages a root map with a double key preserve. Therefore, values added require two keys to be
 * put into the map.
 * @param <K1> The first key type.
 * @param <K2> The second key type.
 * @param <V> The value type.
 */
public class DoubleKeyMapWrapper<K1, K2, V> {

    public static <K1, K2, V> DoubleKeyMapWrapper<K1, K2, V> fromHashMap(){
        return new DoubleKeyMapWrapper<>(new HashMap<>(), new Supplier<Map<K2, V>>() {
            @Override
            public Map<K2, V> get() {
                return new HashMap<>();
            }
        });
    }

    private final Map<K1, Map<K2, V>> root;
    private final Supplier<Map<K2, V>> builder;
    public DoubleKeyMapWrapper(Map<K1, Map<K2, V>> root, Supplier<Map<K2, V>> innerBuilder){
        KleeUtil.paramRequireNonNull(root, "Root map cannot be null!");
        KleeUtil.paramRequireNonNull(innerBuilder, "Inner map builder cannot be null");
        this.root = root;
        this.builder = innerBuilder;
    }

    private Map<K2, V> prepareInner(K1 key){
        Map<K2, V> map = root.get(key);
        if(map == null) root.put(key, (map = builder.get()));
        return map;
    }

    private boolean hasInner(K1 key){
        return root.containsKey(key);
    }

    public V put(K1 key1, K2 key2, V value){
        if(key1 == null)return null;
        if(key2 == null)return null;
        if(value == null)return remove(key1,key2);
        return prepareInner(key1).put(key2,value);
    }

    public void putAll(K1 key, Map<K2, V> map){
        if(key == null)return;
        if(map == null)return;
        prepareInner(key).putAll(map);
    }

    public V remove(K1 key1, K2 key2){
        if(key1 == null || key2 == null)return null;
        if(!containsKeys(key1, key2))return null;
        return prepareInner(key1).remove(key2);
    }

    public boolean containsKeys(K1 key1, K2 key2){
        return (key1 != null && key2 != null) && (hasInner(key1) && root.get(key1).containsKey(key2));
    }

    public Map<K1, Map<K2, V>> getWrapped() {
        return root;
    }
}
