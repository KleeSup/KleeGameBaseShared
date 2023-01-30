package de.kleesup.libraries.gamebase.shared.net.packet.kryo;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.net.packet.Packet;
import de.kleesup.libraries.gamebase.shared.net.packet.PacketProcessor;

import java.util.Map;

/**
 * An implementation of {@link Listener} from KryoNet which utilizes {@link KryoPacketProcessorStorageMap} to
 * <br>Created on 30.01.2023</br>
 * @author KleeSup
 * @version 1.0
 * @since 1.1.3
 */
public class KryoPacketProcessingListener<P extends Packet> implements Listener {

    private final KryoPacketProcessorStorageMap<P> map;
    public KryoPacketProcessingListener(KryoPacketProcessorStorageMap<P> map) {
        KleeUtil.paramRequireNonNull(map, "StorageMap cannot be null!");
        this.map = map;
    }
    public KryoPacketProcessingListener() {
        this(KryoPacketProcessorStorageMap.kryoConcurrent());
    }

    /**
     * Registers a processor to this listeners processor storage.
     * @param clazz The class of the packet.
     * @param processor The processor to register.
     */
    public <T extends P> void registerProcessor(Class<T> clazz, PacketProcessor<T, Connection> processor){
        KleeUtil.paramRequireNonNull(clazz, "Class of the processor to register cannot be null!");
        KleeUtil.paramRequireNonNull(processor, "Processor to register cannot be null!");
        map.register(clazz, processor);
    }

    /**
     * Registers a set of processors to this listeners processor storage.
     * @param map The set of processors to register.
     */
    public <T extends P> void registerAllProcessors(Map<Class<T>, PacketProcessor<T, Connection>> map){
        KleeUtil.paramRequireNonNull(map, "Processors to register cannot be null!");
        for(Map.Entry<Class<T>, PacketProcessor<T, Connection>> entry : map.entrySet()){
            registerProcessor(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void received(Connection connection, Object object) {
        Listener.super.received(connection, object);
        map.process(object, connection);
    }
}
