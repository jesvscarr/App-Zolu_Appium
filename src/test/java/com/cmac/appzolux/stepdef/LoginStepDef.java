package com.cmac.appzolux.stepdef;

import com.cmac.appzolux.views.LoaderComponent;
//import com.cmac.appzolux.views.home.HomeView;
import com.cmac.appzolux.views.LoginView;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

public class LoginStepDef {
	LoginView loginView = new LoginView();
	//HomeView homeView = new HomeView();
	
	
	@Given("Inicio sesión con tarjeta {string}, DNI {string}")
	public void inicioSesionConTarjetaDNI(String numTarjeta, String numDNI) {
		loginView.digitarTarjeta(numTarjeta);
		loginView.digitarDocumento(numDNI);
		loginView.tapContinuar();
	}

	@And("Verifico mi nombre {string} en la pantalla de bienvenida")
	public void verificoMiNombreEnLaPantallaDeBienvenida(String nombreCliente) {
		loginView.verificaNombreCliente(nombreCliente);
	}

	@And("Ingreso con mi clave {string}")
	public void ingresoConMiClave(String claveCliente) {
		loginView.tapBtnClave();
		loginView.digitarClave(claveCliente);
	}

	@Then("Debería ingresar al app y visualizar mi nombre {string}")
	public void deberiaIngresarAlAppYVisualizarMiNombre(String nombreCliente) {
		//homeView.verificaInicioSesion(nombreCliente);
	}

	@Given("He iniciado sesión con tarjeta {string}, DNI {string} y clave {string} con nombre {string}")
	public void heIniciadoSesionConTarjetaDNIYClave(String nTarjeta, String nDocumento, String claveCliente, String nomCli){
		inicioSesionConTarjetaDNI(nTarjeta, nDocumento);
		ingresoConMiClave(claveCliente);
		deberiaIngresarAlAppYVisualizarMiNombre(nomCli);
	}

	@Given("Introduzco Tarjeta del cliente {string}")
	public void introduzcoTarjetaDelCliente(String tarjeta) {
		loginView.digitarTarjeta(tarjeta);
	}

	@And("Introduzco DNI del cliente {string}")
	public void introduzcoDNIDelCliente(String dni) {
		loginView.digitarDocumento(dni);
	}

	@When("Hago tap en el botón Continuar")
	public void hagoTapEnElBotonContinuar() {
		loginView.tapContinuar();
	}

	@Then("La app muestra un modal con el mensaje de aviso {string}")
	public void laAppMuestraUnModalConElMensaje(String mensaje) {
		Assert.assertEquals(mensaje, loginView.getTvMensajeAviso());
	}

	@Then("La app muestra un modal con el mensaje de error {string}")
	public void laAppMuestraUnModalConElMensajeDeError(String mensaje) {
		new LoaderComponent().esperaLoaderOculto();
		Assert.assertEquals(mensaje, loginView.getTvMensajeError());
	}

	@When("le doy click a no no soy yo")
	public void le_doy_click_a_no_no_soy_yo() {
		loginView.linkNoSoyYo();
	}

	@When("al hacer click en el boton cambiar")
	public void al_hacer_click_en_el_boton_cambiar() {
		loginView.btnCambiar();
	}

	@Then("me redirecciona al modulo de login")
	public void me_redirecciona_al_modulo_de_login() {
		assertTrue(loginView.validarRedireccion());
	}

	@When("al hacer click en el continuar")
	public void al_hacer_click_en_el_continuar() {
		loginView.btnContinuarHome();
	}
	@Then("permanece en la misma vista")
	public void permanece_en_la_misma_vista() {
		assertTrue(loginView.validarVistaContinuar());
	}

	@When("ingreso al modulo de contactanos")
	public void ingreso_al_modulo_de_contactanos() {
		loginView.contactanos();
	}
	
	@When("hago clic en llamanos ahora")
	public void hago_clic_en_llamanos_ahora() {
		loginView.llamanos();
	}
	
	@Then("me redirecciona al aplicativo de llamadas")
	public void me_redirecciona_al_aplicativo_de_llamadas() {
		assertTrue(loginView.redireccionLLamadas());
	}

	@When("le doy click en el boton ocultar")
	public void le_doy_click_en_el_boton_ocultar() {
		loginView.btnOcultar();
	}
	
	@Then("validar que los montos no se muestren")
	public void validar_que_los_montos_no_se_muestren() {
		assertTrue(loginView.validarMontoInvisibles());
	}

	@When("ingreso al modulo de bloquear tarjeta")
	public void ingreso_al_modulo_de_bloquear_tarjeta() {
		loginView.bloquearTarjeta();
	}
	
	@Then("validar que parezca el popup")
	public void validar_que_parezca_el_popup() {
		assertTrue(loginView.validarPopUp());
	}

	@Then("validar que el numero de tarjeta este bloqueado")
	public void validar_que_el_numero_de_tarjeta_este_bloqueado() {
		assertTrue(loginView.validarNumeroTarjetaBloqueado());
	}

//	@Given("ingreso al modulo de configuracion de dispositivos")
//	public void ingreso_al_modulo_de_configuracion_de_dispositivos() {
//		menu.tapMenuMas();
//		mas.tapConfiguracionDispositivo();
//	}
//	
//	@Given("ingreso al modulo de bloqueo de trajeta")
//	public void ingreso_al_modulo_de_bloqueo_de_trajeta() {
//		config.bloquearTarjeta();
//	}
//	
//	@Then("validar que el numero de tarjeta visa que este bloqueado")
//	public void validar_que_el_numero_de_tarjeta_visa_que_este_bloqueado() {
//		assertTrue(loginView.validarNumeroTarjetaBloqueadoConfiguracion());
//	}

}