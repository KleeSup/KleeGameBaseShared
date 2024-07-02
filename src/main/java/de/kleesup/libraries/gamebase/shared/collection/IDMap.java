package de.kleesup.libraries.gamebase.shared.collection;

import de.kleesup.libraries.gamebase.shared.IDManager;
import de.kleesup.libraries.gamebase.shared.KleeUtil;

import java.util.*;

public class IDMap<V> extends AbstractMap<UUID, V> implements IDManager {

    private final Map<UUID, V> map;
    public IDMap(Map<UUID, V> map){
        KleeUtil.paramRequireNonNull(map, "Inner map cannot be null!");
        this.map = map;
    }

    public UUID add(V value){
        UUID id = generateNew(value);
        put(id, value);
        return id;
    }

    @Override
    public Set<Entry<UUID, V>> entrySet() {
        return map.entrySet();
    }

    @Override
    public boolean isTaken(UUID id) {
        return map.containsKey(id);
    }
}
