package net.chauhandevs.mod.easyreload.NetworkHook;

import java.net.ServerSocket;
import java.net.SocketTimeoutException;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class SpecificHook implements Runnable{

    protected ServerSocket hookSocket;
    protected int listnerPort = 0;

    protected final Server server;
    protected final Plugin plugin;

    private final Thread hookThread;

    private boolean stop = false;
    

    public SpecificHook(Server server, Plugin plugin, int portRangeStart){
        this.server = server;
        this.plugin = plugin;

        this.hookThread = new Thread(this);

        listnerPort = initHook(portRangeStart);

        if(listnerPort == -1){
            onHookOpenFailed();
        }else {
            onHookOpened();
        }
    }

    public abstract void onHookTriggered();
    public abstract void onHookOpened();
    public abstract void onHookOpenFailed();

    @Override
    public final void run() {
        try{
            hookSocket.setSoTimeout(500);

            while (!stop) {
                try{
                    hookSocket.accept();
                    break;
                }catch(SocketTimeoutException e){} // Ignore the timeout
            }

            //Reload Here:
            if(!stop){
                server.broadcastMessage("Reloading the plugins!!");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        onHookTriggered();
                    }
                }.runTask(plugin);
            }

            hookSocket.close();
        }catch(Exception e){}
    }

    private final int initHook(int portRangeStart){
        int port = portRangeStart;
        
        int portRange = 5; 
        boolean foundPort = false;

        System.out.println("Port Start From: " + portRangeStart);


        //Attach on a port
        while (!foundPort) {
            System.out.println("Port: " + port);
            try{
                hookSocket = new ServerSocket(port);
                foundPort = true;
            }catch(Exception e){
                System.out.println("Can't open on port: " + port + ", Exception: " + e.getMessage());
                port++;
            }

            if(port >= (portRangeStart + portRange)){
                return -1;
            }
        }

        return port;
    }

    public final void startHook(){
        hookThread.start();
    }

    public final void disconnect(){
        stop = true;
    }
    
}
