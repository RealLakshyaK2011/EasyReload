package net.chauhandevs.mod.easyreload.reloadhookserver.hash;

public class ByteInterpretedHash {
    private final byte[] hash = new byte[32];

    public void updateHash(byte[] hash){
        if(hash.length < 32){
            System.err.println("The provided hash in the form of byte array has a size less than 32!");
            return;
        }
        if(hash.length > 32){
            System.err.println("The provided hash in the form of byte array has a size greater than 32! Ignoring rest of the bytes!");
            return;
        }

        for (int i = 0; i < 32; i++){
            this.hash[i] = hash[i];
        }
    }

    public byte[] getHash(){
        return hash;
    }

    public boolean equals(ByteInterpretedHash _hash){
        byte[] hash2 = _hash.hash;
        for (int i = 0; i < 32; i++){
            if(hash[i] != hash2[i]){
                return false;
            }
        }

        return true;
    }
}
