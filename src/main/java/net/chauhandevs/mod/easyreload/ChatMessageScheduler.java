package net.chauhandevs.mod.easyreload;

import org.bukkit.scheduler.BukkitRunnable;

public class ChatMessageScheduler {
    public static void scheduleMessageSend(String message){
        new BukkitRunnable() {
            @Override
            public void run() {
                EasyReload.server.broadcastMessage(message);
            }
        }.runTaskAsynchronously(EasyReload.plugin);
    }
}
