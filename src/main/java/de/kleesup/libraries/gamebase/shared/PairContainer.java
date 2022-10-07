package de.kleesup.libraries.gamebase.shared;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * Am interface for data pairs (key-value principle).
 * @since 1.0
 */
public interface PairContainer<K, V> {

    /**
     * Checks if this container contains a value of a given key.
     * @param key The key to check for.
     * @return {@code true} if this container contains a value of the specified key, {@code false} otherwise.
     */
    boolean has(K key);

    /**
     * Sets a given value for a specified key.
     * @param key The key leading to the value.
     * @param newValue The new value.
     * @return The old value or {@code null} if there wasn't something already set for the key before.
     */
    V set(K key, V newValue);

    /**
     * Retrieves a value by a given key.
     * @param key The key leading to the wanted value.
     * @return The value or {@code null} if the key has no registered value.
     */
    V get(K key);

    /**
     * Retrieves a value by a given key or returns a default value of the key isn't registered.
     * @param key The key leading to the wanted value
     * @param defaultValue The default value returned when {@link #has(Object)} returns {@code false}.
     * @return The value if set or a default value otherwise.
     */
    default V getOrDefault(K key, V defaultValue){
        return has(key) ? get(key) : defaultValue;
    }

    /**
     * Removes a registered key from this pair container.
     * @param key The key with its value to remove.
     * @return The value which was registered for that key, or {@code null} if there was none.
     */
    V remove(K key);

}
