package de.kleesup.libraries.gamebase.shared.net.packet;

import com.esotericsoftware.kryonet.Connection;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 13.10.2022
 *
 * An interface that is capable of executing certain tasks when a specific packet was received.
 * @since 1.1
 */
public interface PacketProcessor<P extends Packet, S> {

    /**
     * Called when a packet was received and now needs to be processed.
     * @param obj The packet object.
     * @param source The source the packet came from (example with Kryo: {@link Connection}).
     */
    void process(P obj, S source);

}
