package net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.nondecimal;

import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.Serializable64bit;

public class SerializableLong extends Serializable64bit<Long> {

    @Override
    protected Long abstractValueOf(Number n) {
        return n.longValue();
    }
}
