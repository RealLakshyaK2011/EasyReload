package net.chauhandevs.mod.easyreload.NetworkHook;

import java.io.File;
import java.io.IOException;

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

        Runtime runtime = Runtime.getRuntime();
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String startScript = "start." + (isWindows ? "bat" : "sh");

        File script = new File(startScript);
        boolean doesScriptExists = script.exists();

        server.shutdown();

        if(!doesScriptExists){
            ChatMessageScheduler.scheduleMessageSend("Can't find the provided start script in configuration. Starting the server without pre-provided arguments!");
        }

        runtime.addShutdownHook(new Thread(new Runnable(){

            @Override
            public void run() {
                if(doesScriptExists){
                    if(isWindows){
                        safeExec(runtime, "cmd.exe /c start " + startScript);
                    }else{
                        safeExec(runtime, "sh " + startScript);
                    }
                }else{
                    String jarPath = "/" + server.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                    jarPath = standardizePath(jarPath);

                    safeExec(runtime, "java -jar " + jarPath);
                }
            }
        }));
    }

    private String standardizePath(String path){
        String step = path.replaceAll("[\\\\/]+", "/");
        if(step.matches("^[\\\\/]+")){
            step = step.replaceFirst("[\\\\/]+", "");
        }

        return step;
    }

    private void safeExec(Runtime r, String command){
        try{
            r.exec(command.split(" "));
        }catch(IOException e){
            System.out.println("Unknown error occurrec: " + e.getMessage());
        }
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
