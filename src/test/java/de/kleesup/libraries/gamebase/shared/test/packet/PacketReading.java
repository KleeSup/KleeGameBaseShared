package de.kleesup.libraries.gamebase.shared.test.packet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import de.kleesup.libraries.gamebase.shared.entity.Controller;
import de.kleesup.libraries.gamebase.shared.entity.PlayerController;
import de.kleesup.libraries.gamebase.shared.net.packet.kryo.KryoPacketProcessorStorageMap;
import de.kleesup.libraries.gamebase.shared.net.packet.PacketProcessorStorageMap;
import de.kleesup.libraries.gamebase.shared.net.packet.ServerPacket;
import de.kleesup.libraries.gamebase.shared.world.Direction;

import java.util.HashMap;

/**
 * @author KleeSup
 * @version 1.0
 * Class created on 13.10.2022
 */
public class PacketReading {

    public static void main(String... args){
        PacketReading instance = new PacketReading();

        instance.testStorage();

        PlayerController controller = new PlayerController();
        controller.registerDirectionControl(Direction.RIGHT, new Controller() {
            @Override
            public float checkController(Direction direction) {
                return Gdx.input.isButtonPressed(Input.Buttons.RIGHT) ? 1 : 0;
            }
        });


    }

    public void testStorage(){

        final PacketProcessorStorageMap<ServerPacket, Void> storageMap = new PacketProcessorStorageMap<>(new HashMap<>());

        storageMap.register(TestServerPacket.class, (obj, source) -> {
            System.out.println("The value is "+obj.someValue + " ;)");
        });

        TestServerPacket packet = new TestServerPacket();
        packet.someValue = 69;
        //storageMap.getProcessor(TestServerPacket.class).process(packet, null);

        storageMap.process(packet, null);

        //kryo
        KryoPacketProcessorStorageMap<ServerPacket> kryoMap = KryoPacketProcessorStorageMap.kryoHash();


    }

}
