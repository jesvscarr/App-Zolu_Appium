package com.cmac.appzolux.views;

import com.igs.utils.MobileDriverDOM;
import com.igs.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginView extends MobileDriverDOM {
	TestUtils utils = new TestUtils();

	// ==================================== Elementos Pre - login ====================================
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='xxxx-xxxx-xxxx-xxxx']")
	private MobileElement txtNumeroTarjeta;

	@AndroidFindBy(accessibility = "Más...")
	private MobileElement menuMas;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Escribir documento']")
	private MobileElement txtNumeroDocumento;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnContinuar")
	private MobileElement btnContinuar;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnGetIt")
	private MobileElement btnEntendido;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnGoDigitalCard")
	private MobileElement btnClienteNuevo;

	@AndroidFindBy(id = "com.cmac.appzolux:id/tvMessage")
	private MobileElement tvMensajeAviso;

	@AndroidFindBy(id = "com.cmac.appzolux:id/textViewMessage")
	private MobileElement tvMensajeError;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnGetIt")
	private MobileElement btnAceptarAviso;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnAccept")
	private MobileElement btnAceptarError;

	@AndroidFindBy(id = "com.cmac.appzolux:id/tvCall")
	private MobileElement btnLlamanos;


	// ==================================== Elementos Menú Inferior ====================================

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnSedes")
	private MobileElement btnUbicanos;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnBlockCard")
	private MobileElement btnBloquearTarjeta;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnBeneficios")
	private MobileElement btnQuieroMas;

	@AndroidFindBy(id = "com.cmac.appzolux:id/linearContact")
	private MobileElement btnContacto;

	// ==================================== Elementos login ====================================
	@AndroidFindBy(id = "com.cmac.appzolux:id/textView4")
	private MobileElement nombreCliente;

	@AndroidFindBy(id = "com.cmac.appzolux:id/tvIsNotMe")
	private MobileElement linkNoSoyYo;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnCambiarDialog")
	private MobileElement btnCambiarPerfil;

	@AndroidFindBy(id = "com.cmac.appzolux:id/ivFingerprint")
	private MobileElement btnHuellaDigital;

	@AndroidFindBy(id = "com.cmac.appzolux:id/btnTeclado")
	private MobileElement btnTecladoClave;

	@AndroidFindBy(id = "com.cmac.appzolux:id/tvVisibility")
	private MobileElement btnVisibilidad;

	@AndroidFindBy(xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[3]")
	private MobileElement btnCuentaNoVisible;

	@AndroidFindBy(id  = "com.cmac.appzolux:id/tvCardNumer")
	private MobileElement numeroTarjeta;


	// ==================================== Elementos Teclado ====================================
	@AndroidFindBy(id = "com.cmac.appzolux:id/tvOlvideClave")
	private MobileElement linkOlvidoClave;

	@AndroidFindBy(id = "com.cmac.appzolux:id/t9_key_clear")
	private MobileElement btnLimpiarDigito;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='1' and contains(@resource-id,'textButton')]")
	private MobileElement key1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='2' and contains(@resource-id,'textButton')]")
	private MobileElement key2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3' and contains(@resource-id,'textButton')]")
	private MobileElement key3;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='4' and contains(@resource-id,'textButton')]")
	private MobileElement key4;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='5' and contains(@resource-id,'textButton')]")
	private MobileElement key5;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='6' and contains(@resource-id,'textButton')]")
	private MobileElement key6;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='7' and contains(@resource-id,'textButton')]")
	private MobileElement key7;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='8' and contains(@resource-id,'textButton')]")
	private MobileElement key8;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='9' and contains(@resource-id,'textButton')]")
	private MobileElement key9;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='0' and contains(@resource-id,'textButton')]")
	private MobileElement key0;


	@AndroidFindBy(id = "com.cmac.appzolux:id/vtContinuarComoS")
	private MobileElement btnContinuarHome;


	// ==================================== Métodos ====================================
	public void digitarTarjeta(String numeroTarjeta) {
		clear(txtNumeroTarjeta);
		sendKeys(txtNumeroTarjeta, numeroTarjeta, "Digitando número de tarjeta: " + numeroTarjeta);
	}

	public void digitarDocumento(String numeroDocumento) {
		clear(txtNumeroDocumento);
		sendKeys(txtNumeroDocumento, numeroDocumento, "Digitando número de documento: " + numeroDocumento);
	}

	public void tapBtnAceptarAviso() {
		click(btnAceptarAviso);
	}

	public void tapBtnAceptarError() {
		click(btnAceptarError);
	}

	public void tapContinuar() {
		click(btnContinuar);
	}

	public String getTvMensajeAviso() {
		return tvMensajeAviso.getText();
	}

	public String getTvMensajeError() {
		return tvMensajeError.getText();
	}

	public void verificaNombreCliente(String nombre) {
		waitForVisibility(nombreCliente);
		Assert.assertEquals("Comparando Nombres en pantalla de bienvenida",
				"¡Hola " + nombre + "!", nombreCliente.getText());
	}

	public void tapBtnClave() {
		click(btnTecladoClave, "Haciendo tap en el botón Clave");
	}

	public void digitarClave(String clave) {
		waitForVisibility(btnLimpiarDigito);
		int longitud = Math.min(clave.length(), 6);
		for (int i = 0; i < longitud; i++) {
			switch (clave.charAt(i)) {
			case '1':
				click(key1);
				break;
			case '2':
				click(key2);
				break;
			case '3':
				click(key3);
				break;
			case '4':
				click(key4);
				break;
			case '5':
				click(key5);
				break;
			case '6':
				click(key6);
				break;
			case '7':
				click(key7);
				break;
			case '8':
				click(key8);
				break;
			case '9':
				click(key9);
				break;
			case '0':
				click(key0);
				break;
			}
		}
	}

	public void cambiarUsuario() {
		click(linkNoSoyYo);
		click(btnCambiarPerfil);
	}

	public boolean AmIinLoginView() {
		return find(txtNumeroTarjeta, 2);
	}


	public boolean AmIinHometapMenuMas() {
		// new LoaderComponent().esperaLoaderOculto();
		if(driver.findElements(By.xpath("//android.widget.LinearLayout[@content-desc=\"Más...\"]")).size()==0 ) return true;
		return false;
	}

	public void linkNoSoyYo()
	{
		click(linkNoSoyYo);
	}

	public void btnCambiar() {
		click(btnCambiarPerfil);
	}

	public boolean validarRedireccion() {
		if(driver.findElements(By.id("com.cmac.appzolux:id/btnContinuar")).size()>0) return true;
		return false;
	}

	public void btnContinuarHome() {
		click(btnContinuarHome);
	}


	public boolean validarVistaContinuar() {
		if(driver.findElements(By.id("com.cmac.appzolux:id/tvIsNotMe")).size()>0) return true;
		return false;
	}

	public void contactanos() {
		click(btnContacto);
	}

	public void llamanos() {
		click(btnLlamanos);
	}

	public boolean redireccionLLamadas() {
		int d=driver.findElements(By.id("com.google.android.dialer:id/digits")).size();
		if(d>0) return true;
		return false;
	}

	public void btnOcultar() {
		click(btnVisibilidad);
	}

	public boolean validarMontoInvisibles() {
		try {
			scrollToElement(btnCuentaNoVisible, "up");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[3]")).size()>0) return true;

		return false;
	}

	public void bloquearTarjeta() {
		new LoaderComponent().esperaLoaderOculto();
		click(btnBloquearTarjeta);
	}

	public boolean validarPopUp() {
		int i=driver.findElements(By.id("com.cmac.appzolux:id/btnGetIt")).size();
		if(driver.findElements(By.id("com.cmac.appzolux:id/btnGetIt")).size()>0) return true;
		return false;
	}

	public boolean validarNumeroTarjetaBloqueado() {

		boolean bolnumerotrajeta=driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText")).get(0).isSelected();
		return !bolnumerotrajeta;
	}

	public boolean validarNumeroTarjetaBloqueadoConfiguracion() {

		boolean bolnumerotrajeta=driver.findElements(By.id("com.cmac.appzolux:id/tvCardNumer")).get(0).isSelected();
		return !bolnumerotrajeta;
	}


}