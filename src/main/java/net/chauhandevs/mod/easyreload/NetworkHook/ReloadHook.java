package net.chauhandevs.mod.easyreload.NetworkHook;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import net.chauhandevs.mod.easyreload.ChatMessageScheduler;

public class ReloadHook extends SpecificHook{

    public ReloadHook(Server server, Plugin plugin, int portRangeStart){
        super(server, plugin, portRangeStart);
    }

    @Override
    public void onHookTriggered() {
        ChatMessageScheduler.scheduleMessageSend("Reloading Plugins!");
        System.out.println("Reload Hook Triggered!");

        server.dispatchCommand(server.getConsoleSender(), "reload");
    }

    @Override
    public void onHookOpened() {
        System.out.println("Successfully opened a ReloadListnerHook on port: " + listnerPort);
        ChatMessageScheduler.scheduleMessageSend("Successfully opened a ReloadListnerHook on port: " + listnerPort);
    }

    @Override
    public void onHookOpenFailed() {
        System.out.println("Unable to open ReloadListnerHook! Please check for issues!");
        ChatMessageScheduler.scheduleMessageSend("Unable to open ReloadListnerHook! Please check for issues!");
    }
}
