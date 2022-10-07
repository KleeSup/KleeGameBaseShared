package de.kleesup.libraries.gamebase.shared.kryo;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 07.10.2022
 *
 * An interface that is capable of registering objects to a given {@link com.esotericsoftware.kryo.Kryo} object.
 * @since 1.0
 */
public interface KryoRegisterer {

    /**
     * Utility method to check if a class is registered in a given kryo object.
     * @param clazz The class to check for.
     * @param kryo The kryo object to check on.
     * @return {@code true} if the class is registered, {@code false} otherwise.
     */
    static boolean isClassRegistered(Class<?> clazz, Kryo kryo){
        try {
            kryo.getRegistration(clazz);
            return true;
        }catch (IllegalArgumentException exception){
            return false;
        }
    }

    /**
     * Registers all necessary objects/classes to a given kryo object.
     * @param kryo The kryo object to register all the classes for.
     */
    void register(Kryo kryo);

}
