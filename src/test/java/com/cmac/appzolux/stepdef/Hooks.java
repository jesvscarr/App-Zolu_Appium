package com.cmac.appzolux.stepdef;

import com.igs.managers.AppiumServerManager;
import com.igs.managers.GlobalParams;
import com.igs.managers.MobileDriverManager;
import com.igs.utils.WordDocument;
import io.cucumber.java.Before;


public class Hooks {
    WordDocument document = new WordDocument();

    @Before
    public static void intialize() throws Exception {
        new GlobalParams().initializeGlobalParams();
        new AppiumServerManager().startServer();
        new MobileDriverManager().initializeDriver();

    }


//    @After
//    public void addScreenshot(Scenario scenario) {
        // Agrega una imagen al finalizar el escenario
//        byte[] screenshot = new MobileDriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", scenario.getName());
//
//        // Agrega el escenario de prueba a la evidencia Word
//        document.addNewScenario(scenario.getName(), String.valueOf(scenario.getStatus()), screenshot);
 
//        try {
//            if (!(new LoginView().AmIinHometapMenuMas())) {
//                new MenuPrincipalView().tapMenuMas();
//                new MenuMasView().cerrarSesion();
//                new LoginView().cambiarUsuario();
//            }
//        } catch (Exception e) {
//            new TestUtils().log().info("Escenario no tiene inicio de sesión. " + e.getMessage());
//        }
//    }

}