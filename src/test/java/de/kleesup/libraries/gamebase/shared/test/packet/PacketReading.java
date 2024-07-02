package de.kleesup.libraries.gamebase.shared.test.packet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import de.kleesup.libraries.gamebase.shared.SnapshotProducer;
import de.kleesup.libraries.gamebase.shared.net.packet.kryo.KryoPacketProcessorStorageMap;
import de.kleesup.libraries.gamebase.shared.net.packet.PacketProcessorStorageMap;
import de.kleesup.libraries.gamebase.shared.net.packet.ServerPacket;

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
        instance.testSnapshot();

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

    public void testSnapshot(){

        Test test = new Test("Hello World");
        System.out.println("Original: "+test);
        TestSnapshot snapshot = test.toSnapshot();
        System.out.println("Snapshot: "+snapshot);

        Test loaded = SnapshotProducer.fromSnapshot(test.getClass(), snapshot);
        System.out.println("Loaded: "+loaded);
    }

    public static class Test implements SnapshotProducer<TestSnapshot> {

        String text;
        public Test(String text){
            this.text = text;
        }

        public Test(TestSnapshot snapshot){
            this.text = snapshot.text;
        }

        @Override
        public TestSnapshot toSnapshot() {
            TestSnapshot testSnapshot =  new TestSnapshot();
            testSnapshot.text = text;
            return testSnapshot;
        }

        @Override
        public String toString() {
            return "Test{text=\""+text+"\"}@"+hashCode();
        }

    }

    public static class TestSnapshot{
        String text;

        @Override
        public String toString() {
            return "TestSnapshot{text=\""+text+"\"}@"+hashCode();
        }
    }

}
