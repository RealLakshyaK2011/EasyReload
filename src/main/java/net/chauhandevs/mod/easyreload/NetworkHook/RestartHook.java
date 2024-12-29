package net.chauhandevs.mod.easyreload.NetworkHook;

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

        server.dispatchCommand(server.getConsoleSender(), "restart");
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
