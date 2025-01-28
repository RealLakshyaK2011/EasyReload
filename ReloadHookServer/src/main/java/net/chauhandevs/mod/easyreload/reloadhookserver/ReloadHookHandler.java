package net.chauhandevs.mod.easyreload.reloadhookserver;

import net.chauhandevs.mod.easyreload.reloadhookserver.hash.ByteInterpretedHash;
import net.chauhandevs.mod.easyreload.reloadhookserver.helper.ReadWriteHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ReloadHookHandler implements Runnable{

    private static final Map<ByteInterpretedHash, ReloadHookHandler> serverHashMap = new HashMap<>();

    private final Socket client;
    private final ReadWriteHelper helper;

    private boolean isServer;

    public ReloadHookHandler(Socket client){
        InputStream in;
        OutputStream out;
        this.client = client;

        try {
            in = client.getInputStream();
            out = client.getOutputStream();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        helper = new ReadWriteHelper(in, out) {
            @Override
            public void onError(IOException thrown) {
                System.err.println("Got an unknown error while communication with the remote, reason: " + thrown.getMessage());
            }
        };
    }

    //Stream structure:
    //<Server/Client >

    @Override
    public void run() {
        //Step 1: Take authentication
        int server_client = helper.read();
        isServer = server_client != 0;

        //For server:
        //Take its hash
        if(isServer){
            byte[] hash = new byte[32];
            ByteInterpretedHash bHash = new ByteInterpretedHash();
            bHash.updateHash(hash);

        }else {

        }

        //Step 2: Acknowledge auth success/fail


        //Step 3: Take/Give instructions

    }


}
