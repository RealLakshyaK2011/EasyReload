package net.chauhandevs.mod.easyreload;

import net.chauhandevs.mod.easyreload.fileio.helper.FolderAccessHelper;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import net.chauhandevs.mod.easyreload.network.*;

import java.io.File;

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

        //Make Data Directory
        System.out.println("HELPER!");
        FolderAccessHelper accessHelper = new FolderAccessHelper("plugins/EasyReload");
        File tempStorage = accessHelper.getFolder("tempPluginsStorage").asFolderAndReset();
        File configFolder = accessHelper.getFolder("config").asFolderAndReset();

        System.out.println(tempStorage.getPath());
        System.out.println(configFolder.getPath());

        reloadHook = new ReloadHook(server, this, 12121);
        restartHook = new RestartHook(server, this, 12126);

        reloadHook.startHook();
        restartHook.startHook();
    }
}
