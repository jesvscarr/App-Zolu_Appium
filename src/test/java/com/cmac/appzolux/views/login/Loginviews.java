package com.cmac.appzolux.views.login;

import com.igs.utils.MobileDriverDOM;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.io.IOException;


/**
 * Clase de la Activity com.cmac.appzolux/com.cmac.appzolux.ui.main.view.MainActivity
 */
public class Loginviews extends MobileDriverDOM {
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	private MobileElement Codigotrabajador;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Iniciar sesión\n" +
			"Ingrese su usuario y contraseña\"]/android.widget.EditText[1]")
	private MobileElement Usuario;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Iniciar sesión\n" +
			"Ingrese su usuario y contraseña\"]/android.widget.EditText[2]")
	private MobileElement Contrasenia;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Iniciar sesión\"]")
	private MobileElement btnIngresar;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Empleados\"]")
	private MobileElement txtEmpleado;
	//-------------------------------------------------------
	public Loginviews() {
	}

	public void enviarcodigotrabajador(String usuario ,String contrasenia ) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(Usuario);
		sendKeys(Usuario, usuario);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		click(Contrasenia);
		sendKeys(Contrasenia, contrasenia);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   //-----------------------------------------------------
	public void TapIngresar() throws InterruptedException, IOException {
		click(btnIngresar);
	}
	//--------------------------------------------------
	public String Empleado() {
		return txtEmpleado.getText();
	}


	@Override
	public void clearAppCache() {
		// Tu implementación
	}

}


