package net.chauhandevs.mod.easyreload.NetworkHook;

import java.io.File;
import java.io.FileNotFoundException;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.chauhandevs.mod.easyreload.ChatMessageScheduler;

public class RestartHook extends SpecificHook{

    public RestartHook(Server server, Plugin plugin, int portRangeStart){
        super(server, plugin, portRangeStart);
    }

    @Override
    public void onHookTriggered() {
        ChatMessageScheduler.scheduleMessageSend("Restarting the server to reload the plugins!");
        System.out.println("Restart Hook Triggered!");

        try {
            File script = new File("./start.bat");
            if(!script.exists()) throw new FileNotFoundException("Unable to find the file: \'start.bat\' !");

            Runtime.getRuntime().exec("cmd.exe /c \"start start.bat\"".split(" "));
        } catch (Exception e) {
            System.err.println("Unable to restart the server, reason: " + e.getMessage());
        };

        server.dispatchCommand(server.getConsoleSender(), "stop");
    }

    @Override
    public void onHookOpened() {
        System.out.println("Successfully opened a RestartListnerHook on port: " + listnerPort);
        ChatMessageScheduler.scheduleMessageSend("Successfully opened a RestartListnerHook on port: " + listnerPort);
    }

    @Override
    public void onHookOpenFailed() {
        System.out.println("Unable to open RestartListnerHook! Please check for issues!");
        ChatMessageScheduler.scheduleMessageSend("Unable to open RestartListnerHook! Please check for issues!");
    }
}
