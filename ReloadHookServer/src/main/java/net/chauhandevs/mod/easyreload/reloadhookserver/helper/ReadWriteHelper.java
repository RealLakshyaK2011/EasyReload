package net.chauhandevs.mod.easyreload.reloadhookserver.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ReadWriteHelper {

    private final InputStream in;
    private final OutputStream out;
    private boolean error = false;

    public ReadWriteHelper(InputStream in, OutputStream out){
        this.in = in;
        this.out = out;
    }

    protected abstract void onError(IOException thrown);

    //Read
    public int read(){
        try {
            return in.read();
        }catch (IOException e){
            error = true;
            onError(e);
            return -1;
        }
    }

    public int read(byte[] b){
        try {
            return in.read(b);
        }catch (IOException e){
            error = true;
            onError(e);
            return -1;
        }
    }

    public int read(byte[] b, int off, int len){
        try {
            return in.read(b, off, len);
        }catch (IOException e){
            error = true;
            onError(e);
            return -1;
        }
    }

    //Other half
    public byte[] readNBytes(int len){
        try {
            return in.readNBytes(len);
        }catch (IOException e){
            error = true;
            onError(e);
            return null;
        }
    }

    public int readNBytes(byte[] b, int off, int len){
        try {
            return in.readNBytes(b, off, len);
        } catch (IOException e) {
            error = true;
            onError(e);
            return -1;
        }
    }

    //Write
    public void write(int b){
        try {
            out.write(b);
        }catch (IOException e){
            error = true;
            onError(e);
        }
    }

    public void write(byte[] b){
        try {
            out.write(b);
        }catch (IOException e){
            error = true;
            onError(e);
        }
    }

    public void write(byte[] b, int off, int len){
        try {
            out.write(b, off, len);
        }catch (IOException e){
            error = true;
            onError(e);
        }
    }

}
