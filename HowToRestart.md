# How to setup restart.

## This article will guide you how to setup the restart functionality of the server.

In spigot or its fork (eg Paper) servers, there is an additional command available called `/restart`, one thing to note that this command is not present in bukkit/vanilla servers.  
As this plugin `(EasyReload)` is going to be ran on spigot or any other spigot fork, this won't be much of an issue. 

As it's name suggests, it is used to restart your server. And on top of all that, this plugin requires this command to be setupped properly otherwise the server restarting functionality will not work as that is depended on this command.    

Now, when the server is shutted off by using the `/restart` command, it looks into configuration files and finds the script that is used to start the server.  
If you are on Windows, it is going to be a `.bat` file and it would be a `.sh` file for macOS and linux based distributions.  
What is this script's purpose? Well, it is obviously to start the server but it has more to it, such as additional arguments given to the JVM running the server and the server software itself.  
For eg, a typical `.bat (windows batch script)` to run a server would be containing this code: `java -Xms256m -Xmx1g -jar spigot-version.jar --nogui`  
The `-Xms` and `-Xmx` provides jvm the heap allocation it needs and `--nogui` tells spigot to not to show any Graphical User Interface (GUI for short.)  
If you haven't made one start script already, firstly create the script and then come back to this as that will be handy later on.

Now, open up the `spigot.yml` file, search for the line `restart-script`, it would typically look like: `restart-script: <something>` and replace that something after `restart-script: ` and follow the below steps according to your enviroment:  

### For windows:
Just enter the name of your startup script with its extension, for e.g. if your startup script name is `start.bat`, insert `start.bat` there.

### For macOS or Linux based systems:
Insert a period `(.)` and a forward-slash `(/)` and after that, the name of the startup script.  
E.g. if your script name is `start.sh`, insert `./start.sh` there.
