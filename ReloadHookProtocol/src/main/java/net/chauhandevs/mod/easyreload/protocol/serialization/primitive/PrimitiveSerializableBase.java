package net.chauhandevs.mod.easyreload.protocol.serialization.primitive;

import net.chauhandevs.mod.easyreload.protocol.serialization.SerializableObject;

public abstract class PrimitiveSerializableBase<T extends U, U> implements SerializableObject {

    private T value;

    public final void set(T value){
        this.value = value;
    }

    public final T get(){
        return value;
    }

    protected U internalGet(){
        return get();
    }

    protected abstract T abstractValueOf(Number n);
}
