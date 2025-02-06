package com.cmac.appzolux.stepdef.login;

import com.cmac.appzolux.views.login.Loginviews;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class loginstepdef {

	private static final Logger log = LoggerFactory.getLogger(loginstepdef.class);
	private Loginviews login = new Loginviews();
	private AppiumDriver<MobileElement> driver; // Cambia el tipo de driver aquí


	//-----------------------------------------------------------------------------------------------
	@Given("ingreso al aplicacion con usuario {string} y contrasenia {string}")
	public void ingresoalaplicacionconusuarioycontrasenia(String usuario, String contrasenia) {
		login.enviarcodigotrabajador(usuario, contrasenia);
	}
	//------------------------------------------------------------------------------------------------
	@And("hago tap en el boton ingresar")
	public void hagotalbotoningresar() throws InterruptedException{
		Thread.sleep(1000);
        try {
            login.TapIngresar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	//-----------------------------------------------------------------------------------------------



//------------------------------------------------------------
	@Then("valido vista Empleados {string}")
	public void txtVista(String vista) throws InterruptedException {
		switch (vista){
			case "Empleados":
				Assert.assertEquals(login.Empleado(), vista);
				break;
			}
		}
//------------------------------------------------------------


	private void esperarElementoYTapear(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		} catch (Exception e) {
			log.error("Error al hacer tap en el elemento: " + by.toString(), e);
			throw new RuntimeException("No se pudo hacer tap en el elemento: " + by.toString(), e);
		}
	}

	@After
	public void teardown() {
		// Cierra la sesión o reinicia la aplicación aquí
		if (driver != null) {
			driver.quit(); // O cualquier otra lógica de limpieza necesaria
		}
	}
}
