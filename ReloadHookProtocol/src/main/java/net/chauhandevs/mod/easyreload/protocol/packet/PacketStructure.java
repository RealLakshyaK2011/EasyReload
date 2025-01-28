package net.chauhandevs.mod.easyreload.protocol.packet;

import net.chauhandevs.mod.easyreload.protocol.serialization.SerializableObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacketStructure {

    private final List<SerializableObject> builder = new ArrayList<>();
    private Map<String, Integer> nameIndexPair = new HashMap<>();

    private SerializableObject[] orderedStructure;
    private boolean structureFinalized = false;

    private int index = 0;

    public boolean available(){
        return !(index >= orderedStructure.length-1);
    }

    public SerializableObject next(){
        SerializableObject o = orderedStructure[index];
        if(index < orderedStructure.length - 1){
            index++;
        }

        return o;
    }

    protected void resetPosition(){
        index = 0;
    }

    protected PacketStructure addField(String name, SerializableObject type){
        nameIndexPair.put(name, builder.size());
        builder.add(type);
        return this;
    }

    protected PacketStructure resetStructureBuild(){
        builder.clear();
        return this;
    }

    protected PacketStructure finalizeStructure(){
        if (!structureFinalized){
            structureFinalized = true;
            orderedStructure = builder.toArray(new SerializableObject[0]);
        }
        return this;
    }

}
