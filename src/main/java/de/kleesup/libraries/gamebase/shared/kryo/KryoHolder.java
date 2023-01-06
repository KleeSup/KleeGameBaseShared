package de.kleesup.libraries.gamebase.shared.kryo;

import com.esotericsoftware.kryo.Kryo;

/**
 * <br>Created on 19.10.2022</br>
 * <br>Simple interface for classes holding a {@link Kryo} instance.</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public interface KryoHolder {

    Kryo getKryo();

}
