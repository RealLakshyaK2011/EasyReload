package net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.nondecimal;

import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.Serializable32bit;

public final class SerializableInteger extends Serializable32bit<Integer> {

    @Override
    protected Integer abstractValueOf(Number n) {
        return n.intValue();
    }
}
