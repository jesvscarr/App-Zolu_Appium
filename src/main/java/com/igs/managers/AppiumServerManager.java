package com.igs.managers;

import com.igs.utils.TestUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class AppiumServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer() {
        return AppiumServerManager.server.get();
    }

    /**
     * Inicia servidor appium
     */
    public void startServer() {
        utils.log().info("Iniciando servidor APPIUM");
        AppiumDriverLocalService appiumDriverLocalService = WindowGetAppiumService();
        appiumDriverLocalService.start();
        if (!appiumDriverLocalService.isRunning()) {
            utils.log().fatal("No se inició el servidor APPIUM");
            throw new AppiumServerHasNotBeenStartedLocallyException("Servidor Appium no iniciado");
        }

        AppiumServerManager.server.set(appiumDriverLocalService);
        utils.log().info("Servidor Appium Iniciado");
    }


    /**
     * Método para iniciar servidor en Windows
     *
     * @return AppiumDriverLocalService
     */
    public AppiumDriverLocalService WindowGetAppiumService() {
        GlobalParams params = new GlobalParams();
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "C:/Program Files/Common Files/Oracle/Java/javapath;%SystemRoot%/system32;%SystemRoot%;" +
                "%SystemRoot%/System32/Wbem;%SYSTEMROOT%/System32/WindowsPowerShell/v1.0/;%SYSTEMROOT%/System32/OpenSSH/;" +
                "C:/Program Files/nodejs/;%ANDROID_HOME%/emulator;%ANDROID_HOME%/cmdline-tools/latest/bin;" +
                "%ANDROID_HOME%/platform-tools;%JAVA_HOME%/bin" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "C:/Users/user.jcarrion/AppData/Local/Android/Sdk");
        environment.put("JAVA_HOME", "C:/Program Files/Java/jdk-11");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))

                //.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("C:/Users/user.jcarrion/AppData/Roaming/npm/node_modules/appium/lib/main.js"))

                .usingAnyFreePort()
                .withIPAddress("0.0.0.0")
                .usingPort(4723)
                //.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                //.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withEnvironment(environment)
                .withLogFile(new File("Logs/" + params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

    /**
     * Método usado para ejecutar por Mac.
     *
     * @return AppiumDriverLocalService
     */
    public AppiumDriverLocalService MacGetAppiumService() {
        GlobalParams params = new GlobalParams();
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/tools:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Users/lorenzoangulo/.npm-global/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/tools:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Users/lorenzoangulo/.npm-global/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/tools:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Users/lorenzoangulo/.npm-global/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/tools:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Users/lorenzoangulo/.npm-global/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/tools:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/Users/lorenzoangulo/.npm-global/bin:/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home/bin:/usr/local/bin:/usr/local/bin:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/local/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/bin:/var/run/com.apple.security.cryptexd/codex.system/bootstrap/usr/appleinternal/bin:/Applications/CyberArk EPM.app/Contents/Helpers:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/emulator:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/emulator:/Users/lorenzoangulo/Library/Android/sdk/tools:/Users/lorenzoangulo/Library/Android/sdk/tools/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/Library/Android/sdk/emulator:/Users/lorenzoangulo/Library/Android/sdk/tools:/Users/lorenzoangulo/Library/Android/sdk/tools/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools:/Users/lorenzoangulo/.npm-global/bin:/Users/lorenzoangulo/Library/Android/sdk/platform-tools" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/lorenzoangulo/Library/Android/sdk");
        environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/temurin-21.jdk/Contents/Home");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                //.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("/Users/lorenzoangulo/.npm-global/lib/node_modules/appium/index.js"))
                .usingAnyFreePort()
                .withIPAddress("0.0.0.0")
                .usingPort(4723)
                //.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                //.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withEnvironment(environment)
                .withLogFile(new File("Logs/" + params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }
    
    
   
}

