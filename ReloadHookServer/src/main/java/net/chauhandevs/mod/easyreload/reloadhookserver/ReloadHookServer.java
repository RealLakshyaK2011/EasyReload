package net.chauhandevs.mod.easyreload.reloadhookserver;

import javax.management.InstanceAlreadyExistsException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ReloadHookServer {

    private static ReloadHookServer instance;

    private final int port;

    private ServerSocket listeningSocket;
    private boolean opened = false;

    public ReloadHookServer(int port){
        if(getInstance() != null) throw new RuntimeException("The instance of ReloadHookServer already exists!\n" +
                "Don't create another instance of it unless the instance is destroyed! It is created at the start of the program.");

        this.port = port;
    }

    public void openHook(){
        if(opened) return;
        ServerSocket socket;

        try{
            socket = new ServerSocket(this.port);

        }catch (IOException e){
            System.err.println("Unable to open hook, reason: " + e.getMessage());
            return;
        }

        listeningSocket = socket;
        opened = true;
    }

    public static ReloadHookServer getInstance() {
        return instance;
    }

    public ServerSocket getListeningSocket() {
        return listeningSocket;
    }

    public static void main(String[] args) {
        System.out.println("Hello, Hook!\n");
        int port = -1;

        if(args.length < 1){
            System.err.println("The port is not provided in arguments, exiting!");
        }
        if(args.length >= 2){
            System.err.println("More than 1 arguments are provided, only the first one, i.e: port, that defines the port number to listen on is used and rest are ignored!");
        }

        try{
            port = Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            System.err.println("The provided argument as the port is not a valid integer! reason: " + e.getMessage());
            System.err.println("Exiting the hook!!!");
            return;
        }

        if(port > 65565 || port < 1){
            System.err.println("The provided port is outside the range of 1 to 65565!");
        }

        ReloadHookServer server = new ReloadHookServer(port);
        server.openHook();

        enterMainLoop();
    }

    //Main Loop

    private static void enterMainLoop(){
        ReloadHookServer server = getInstance();
        ServerSocket hook = server.getListeningSocket();
        Socket acceptedSocket;

        try {
            hook.setSoTimeout(1);
        }catch (SocketException e){
            internalError(e);
        }

        //Main Loop
        while (true){
            //try to accept connection
            acceptedSocket = null;
            try {
                acceptedSocket = hook.accept();
            }catch (SocketTimeoutException timeoutE){}
            catch (IOException e){
                internalError(e);
            }

            if(acceptedSocket != null){

            }


        }
    }

    private static void internalError(Exception e){
        System.err.println("Got an internal error! Reason: " + e.getMessage());
    }
}
