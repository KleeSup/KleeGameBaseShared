package de.kleesup.libraries.gamebase.shared.kryo;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author KleeSup
 * @version 1.1
 * Class created on 07.10.2022
 *
 * An interface that is capable of registering objects to a given {@link com.esotericsoftware.kryo.Kryo} object.
 * @since 1.0
 */
public interface KryoRegisterer {

    /**
     * Registers all necessary objects/classes to a given kryo object.
     * @param kryo The kryo object to register all the classes for.
     */
    void register(Kryo kryo);

}
