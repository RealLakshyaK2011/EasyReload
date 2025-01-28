package net.chauhandevs.mod.easyreload.protocol.serialization;

public interface SerializableObject {

    void deserialize(byte[] data);
    byte[] serialize();

    int getSerializationLength();
}
