package net.chauhandevs.mod.easyreload.protocol.packet;

import net.chauhandevs.mod.easyreload.protocol.serialization.SerializableObject;

import java.util.HashMap;
import java.util.Map;

public abstract class Packet implements SerializableObject {
    protected final PacketStructure structure = new PacketStructure();
    protected final Map<String, SerializableObject> payload = new HashMap<>();

    @Override
    public final void deserialize(byte[] data) {

    }

    @Override
    public final byte[] serialize() {
        return new byte[0];
    }

    @Override
    public int getSerializationLength() {
        int len = 0;
        while (structure.available()){
            SerializableObject object = structure.next();
            len += object.getSerializationLength();
        }
        return len;
    }
}
