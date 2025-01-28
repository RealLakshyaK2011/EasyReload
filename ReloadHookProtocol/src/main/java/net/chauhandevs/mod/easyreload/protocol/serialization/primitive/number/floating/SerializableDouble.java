package net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.floating;

import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.Serializable64bit;

public class SerializableDouble extends Serializable64bit<Double> {
    @Override
    protected Double abstractValueOf(Number n) {
        return Double.longBitsToDouble(n.longValue());
    }

    @Override
    protected Number internalGet() {
        return Double.doubleToRawLongBits(get());
    }
}
