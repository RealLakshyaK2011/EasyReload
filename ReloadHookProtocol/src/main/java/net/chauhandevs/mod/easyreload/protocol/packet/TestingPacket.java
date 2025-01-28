package net.chauhandevs.mod.easyreload.protocol.packet;

import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.floating.SerializableFloat;
import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.nondecimal.SerializableInteger;

public class TestingPacket extends Packet{

    public TestingPacket(){
        structure.addField("itemid", new SerializableInteger())
                .addField("buy_price", new SerializableFloat()).finalizeStructure();
    }
}
