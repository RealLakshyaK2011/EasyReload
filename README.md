# EasyReload

<img src="EasyReloadIcon.png" alt="drawing" style="width:200px;"/> 

## What is this plugin?
This plugin, simply put, automates the process of taking the built plugin and applying it to the plugin devlopment/testing server. 
It is meant for bukkit/spigot plugin devlopers to automate the process of building and testing the binaries with ease.

## Prerequisites/Requirements:
1. Requires Gradle to be the build system of your project.
2. Requires that the plugin testing/devlopment server be on the same machine.
3. Any port being free in the range `12121 to 12125` and `12126 to 12130`.
4. The server start script, either batch `(.bat)` for windows or bash `.sh` for macOS/Linux should have the name `start.<extension>` otherwish the server might not restart as intended i.e. without any custom arguments provided to it.

#### Version Specific:
1. On version 1.0, the plugin depended on the `/reload` and `/restart` commands, and it only ran on Spigot. Make sure to setup `/restart` appropriately according to your enviroment.
2. From version 1.1, all functionalities do work on bukkit servers too.

## Installation:

1. Take the plugin JAR file and place it in your server's plugin directory.
2. Take the `easyreload.gradle` file (present in the `easyreload.gradle.zip` zip file.), and place it in your project's home directory. (i.e. where your build scripts lies)
3. In your project's `build.gradle` file, add the following line of code: `apply from: 'easyreload.gradle'`
4. Lastly, in your `gradle.properties` file, add the following two properties: `serverDir` and `shouldRestart`

Note:
1. The `serverDir` property should be set to where your server files are.
2. The `shouldRestart` property can only have the following values: `true` or `false`. And it determines whether it should completely restart the server or just **"reload"** the plugins. (Useful in some cases).
3. Changing the `shouldRestart` property to anything else than `true` or `false` will result in the post build steps failing.
