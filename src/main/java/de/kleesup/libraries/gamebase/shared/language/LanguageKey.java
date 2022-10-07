package de.kleesup.libraries.gamebase.shared.language;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * A class for creating static language-content identifiers.
 *
 * Each language key holds a string-value (optionally with parameters).
 * A key can be parsed by {@link Language#translate(LanguageKey, Object...)}.
 * @since 1.0
 */
public class LanguageKey {
    //a map containing all registered key with their id as the key.
    private static final Map<String, LanguageKey> MAP_ID = new ConcurrentHashMap<>();

    /**
     * Retrieves the key by a given id. If the id is null or there's no registered key under the specified id,
     * {@code null} will be returned.
     * @param id The id of the key to return.
     * @return The key which is registered under the specified id.
     */
    public static LanguageKey valueOf(final String id){
        return id != null ? MAP_ID.get(id) : null;
    }

    /**
     * Checks if a key-id is registered.
     * @param id The id to check for.
     * @return {@code true} if the id is registered, {@code false} otherwise.
     */
    public static boolean isRegistered(final String id){
        return id != null && MAP_ID.containsKey(id);
    }

    private final String id;
    private final String defaultValue;
    private final int paramAmount;
    public LanguageKey(final String id, final String defaultValue, final int paramAmount){
        this.id = id;
        this.defaultValue = defaultValue;
        this.paramAmount = Math.max(0, paramAmount);
        MAP_ID.put(id, this);
    }
    public LanguageKey(final String id, final String defaultValue){
        this(id, defaultValue, 0);
    }

    public String getId() {
        return id;
    }

    /**
     * @return the amount of parameters it needs to fully parse.
     */
    public int getParamAmount() {
        return paramAmount;
    }

    /**
     * @return The registered default value for this key.
     */
    public String getDefaultValue() {
        return defaultValue;
    }
}
