package de.kleesup.libraries.gamebase.shared.world.kryo;

import com.esotericsoftware.kryonet.Connection;
import de.kleesup.libraries.gamebase.shared.world.IWorldObject2D;

/**
 * <br>Created on 22.10.2022</br>
 * An implementation of {@link IWorldObject2D} which can hold a {@link Connection} instance.
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public interface KryoNetWorldObject2D extends IWorldObject2D {

    Connection getConnection();

}
