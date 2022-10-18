package de.kleesup.libraries.gamebase.shared.net.packet;

import com.esotericsoftware.kryonet.Connection;
import de.kleesup.libraries.gamebase.shared.KleeUtil;
import de.kleesup.libraries.gamebase.shared.exception.GameException;
import de.kleesup.libraries.gamebase.shared.net.packet.kryo.KryoPacketProcessorStorageMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 18.10.2022
 *
 * A class to storage packets with their according processors. The storage type is Javas {@link Map}.
 * @since 1.1
 */
public class PacketProcessorStorageMap<P extends Packet, S> {

    /**
     * Builds a {@link PacketProcessorStorageMap} which uses a {@link ConcurrentHashMap} as storage.
     * @param <P> The packet type.
     * @param <S> The source type.
     * @return The new build {@link PacketProcessorStorageMap}.
     */
    public static <P extends Packet, S> PacketProcessorStorageMap<P, S> concurrent(){
        return new PacketProcessorStorageMap<>(new ConcurrentHashMap<>());
    }

    /**
     * Builds a {@link PacketProcessorStorageMap} which uses a {@link HashMap} as storage.
     * @param <P> The packet type.
     * @param <S> The source type.
     * @return The new build {@link PacketProcessorStorageMap}.
     */
    public static <P extends Packet, S> PacketProcessorStorageMap<P, S> hash(){
        return new PacketProcessorStorageMap<>(new HashMap<>());
    }

    /**
     * Builds a {@link KryoPacketProcessorStorageMap} which uses a {@link HashMap} as storage
     * and Kryos {@link Connection} as packet source in the {@link PacketProcessor} interface.
     * @param <P> The packet type.
     * @return The new build {@link KryoPacketProcessorStorageMap}.
     */
    public static <P extends Packet> KryoPacketProcessorStorageMap<P> kryoHash(){
        return new KryoPacketProcessorStorageMap<>(new HashMap<>());
    }

    /**
     * Builds a {@link KryoPacketProcessorStorageMap} which uses a {@link ConcurrentHashMap} as storage
     * and Kryos {@link Connection} as packet source in the {@link PacketProcessor} interface.
     * @param <P> The packet type.
     * @return The new build {@link KryoPacketProcessorStorageMap}.
     */
    public static <P extends Packet> KryoPacketProcessorStorageMap<P> kryoConcurrent(){
        return new KryoPacketProcessorStorageMap<>(new ConcurrentHashMap<>());
    }

    /*
    Constructor
    */

    private final Map<Class<? extends P>, PacketProcessor<? extends P, S>> storage;
    public PacketProcessorStorageMap(Map<Class<? extends P>, PacketProcessor<? extends P, S>> storage) {
        KleeUtil.paramRequireNonNull(storage, "Map cannot be null!");
        this.storage = storage;
    }

    /*
    Implementation
    */

    /**
     * Tries to register a packet with its processor to this storage.
     * @param packetClass The class of the packet.
     * @param processor The processor applied to the packet.
     * @param <T> The packet type.
     */
    public <T extends P> void register(Class<T> packetClass, PacketProcessor<T, S> processor){
        KleeUtil.paramRequireNonNull(packetClass, "Class to register cannot be null!");
        KleeUtil.paramRequireNonNull(processor, "Processor to register cannot be null!");
        storage.put(packetClass, processor);
    }

    /**
     * Tries to process a packet with the given packets object and the source it came from.
     * @param obj The packet object to process.
     * @param source The source the packet came from.
     */
    @SuppressWarnings("unchecked")
    public void process(Object obj, S source){
        if(!(obj instanceof Packet))throw new IllegalArgumentException("Object to process is not a valid packet!");
        if(!has((Class<? extends P>) obj.getClass()))throw new GameException("The packet to process is not registered in this storage!");
        PacketProcessor<P, S> processor = (PacketProcessor<P, S>) getProcessor((Class<? extends P>)obj.getClass());
        processor.process((P)obj, source);
    }

    /**
     * Checks if a packets class is registered in this storage.
     * @param packetClass The class of the packet.
     * @return {@code true} if the class is registered, {@code false} otherwise.
     */
    public boolean has(Class<? extends P> packetClass){
        KleeUtil.paramRequireNonNull(packetClass, "Class cannot be null!");
        return storage.containsKey(packetClass);
    }

    /**
     * Retrieves a registered packet processor. If there is no processor registered with the specified class, a
     * {@link IllegalArgumentException} is thrown.
     * @param packetClass The class that is registered in the storage.
     * @param <T> The type of the packet.
     * @return The processor of the registered packet (class).
     */
    @SuppressWarnings("unchecked")
    public <T extends P> PacketProcessor<T, S> getProcessor(Class<T> packetClass){
        KleeUtil.paramRequireNonNull(packetClass, "Class cannot be null!");
        return (PacketProcessor<T, S>) storage.get(packetClass);
    }



}
