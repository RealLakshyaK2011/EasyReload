package net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.floating;

import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.Serializable32bit;

public final class SerializableFloat extends Serializable32bit<Float> {


    @Override
    protected Float abstractValueOf(Number n) {
        return Float.intBitsToFloat(n.intValue());
    }

    @Override
    protected Number internalGet() {
        return Float.floatToRawIntBits(get());
    }
}
