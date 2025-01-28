package net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number;

import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.PrimitiveSerializableBase;

public abstract class Serializable32bit<T extends Number> extends PrimitiveSerializableBase<T, Number> {

    @Override
    public byte[] serialize() {
        int val = internalGet().intValue();
        int right8bitAllowMask = 0xFF; //1111 1111 in binary
        byte[] data = new byte[getSerializationLength()];

        for(int i = 0; i < getSerializationLength(); i++){
            data[i] = (byte) (val & right8bitAllowMask);
            System.out.println((val & right8bitAllowMask));

            val = val >>> 8;
        }

        return data;
    }

    @Override
    public void deserialize(byte[] data) {
        int num = 0;
        int sl = getSerializationLength();
        int bss = (sl * 8) - 8;
        if(data.length != sl){
            throw new IllegalArgumentException("Invalid Byte Data");
        }

        for (int i = 0; i < sl; i++){
            int byteValShifted = (((data[i] << bss) >>> bss) << (i*8));

            num = num | (byteValShifted);
        }

        set(abstractValueOf(num));
    }

    @Override
    public final int getSerializationLength() {
        return 4;
    }

}
