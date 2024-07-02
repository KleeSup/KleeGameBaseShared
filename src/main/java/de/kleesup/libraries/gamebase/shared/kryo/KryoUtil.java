package de.kleesup.libraries.gamebase.shared.kryo;

import com.esotericsoftware.kryo.Kryo;
import de.kleesup.libraries.gamebase.shared.KleeUtil;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 18.10.2022
 *
 * A utility class for the Kryo package which contains some simple and helpful methods.
 * @since 1.1
 */
public class KryoUtil {

    /**
     * Registers a set of classes for a specified {@link Kryo} instance.
     * @param kryo The kryo object to write to.
     * @param classes The classes to register.
     */
    public static void registerAllFor(Kryo kryo, Class<?>... classes){
        KleeUtil.paramRequireNonNull(kryo, "Kryo instance cannot be null!");
        if(classes == null)return;
        for(Class<?> clazz : classes){
            kryo.register(clazz);
        }
    }

    /**
     * Utility method to check if a class is registered in a given kryo object.
     * @param clazz The class to check for.
     * @param kryo The kryo object to check on.
     * @return {@code true} if the class is registered, {@code false} otherwise.
     */
    public static boolean isClassRegistered(Class<?> clazz, Kryo kryo){
        try {
            kryo.getRegistration(clazz);
            return true;
        }catch (IllegalArgumentException exception){
            return false;
        }
    }

}
