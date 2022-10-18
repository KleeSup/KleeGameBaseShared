package de.kleesup.libraries.gamebase.shared.net.packet.kryo;

import com.esotericsoftware.kryonet.Connection;
import de.kleesup.libraries.gamebase.shared.net.packet.Packet;
import de.kleesup.libraries.gamebase.shared.net.packet.PacketProcessor;
import de.kleesup.libraries.gamebase.shared.net.packet.PacketProcessorStorageMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 18.10.2022
 *
 * An implementation of {@link PacketProcessorStorageMap} which utilizes Kryos {@link Connection} as packet source.
 * @since 1.1
 */
public class KryoPacketProcessorStorageMap<P extends Packet> extends PacketProcessorStorageMap<P, Connection> {
    
    public KryoPacketProcessorStorageMap(Map<Class<? extends P>, PacketProcessor<? extends P, Connection>> storage) {
        super(storage);
    }
}
