package de.kleesup.libraries.gamebase.shared.world.kryo;

import com.esotericsoftware.kryonet.Connection;
import de.kleesup.libraries.gamebase.shared.world.IWorldObject3D;

/**
 * <br>Created on 22.10.2022</br>
 * An implementation of {@link IWorldObject3D} which can hold a {@link Connection} instance.
 * @author KleeSup
 * @version 1.0
 * @since 1.2
 */
public interface KryoNetWorldObject3D<Id> extends IWorldObject3D<Id> {

    Connection getConnection();

}
