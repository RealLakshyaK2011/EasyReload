# EasyReload

<img src="EasyReloadIcon.png" alt="drawing" style="width:200px;"/> 

## What is this plugin?
This plugin, simply put, automates the process of taking the built plugin and applying it to the plugin devlopment/testing server. 
It is meant for bukkit/spigot plugin devlopers to automate the process of building and testing the binaries with ease.

## Prerequisites/Requirements:
1. Requires Gradle to be the build system of your project.
2. Requires that the plugin testing/devlopment server be on the same machine.
3. Any port being free in the range `12121 to 12125` and `12126 to 12130`.
4. Make sure you can restart the server with the /restart command, otherwise the restart functionality will not work.
5. More info on how to setup restart [here](HowToRestart.md)

## Installation:

1. Take the plugin JAR file and place it in your server's plugin directory.
2. Take the `easyreload.gradle` file (present in the `easyreload.gradle.zip` zip file.), and place it in your project's home directory. (i.e. where your build scripts lies)
3. In your project's `build.gradle` file, add the following line of code: `apply from: 'easyreload.gradle'`
4. Lastly, in your `gradle.properties` file, add the following two properties: `serverDir` and `shouldRestart`

Note:
1. The `serverDir` property should be set to where your server files are.
2. The `shouldRestart` property can only have the following values: `true` or `false`. And it determines whether it should completely restart the server or just **"reload"** the plugins. (Useful in some cases).
3. Changing the `shouldRestart` property to anything else than `true` or `false` will result in the post build steps failing.
