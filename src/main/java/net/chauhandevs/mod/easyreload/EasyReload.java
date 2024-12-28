package net.chauhandevs.mod.easyreload;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import net.chauhandevs.mod.easyreload.NetworkHook.*;

public final class EasyReload extends JavaPlugin {

    public static Server server;
    public static EasyReload plugin;
    
    public ReloadHook reloadHook;
    public RestartHook restartHook;

    @Override
    public void onDisable(){
        System.err.println("Disabling the plugin!");
        reloadHook.disconnect();
        restartHook.disconnect();
    }

    @Override
    public void onEnable(){
        server = getServer();
        plugin = this;

        reloadHook = new ReloadHook(server, this, 12121);
        restartHook = new RestartHook(server, this, 12126);

        reloadHook.startHook();
        restartHook.startHook();
    }
}
