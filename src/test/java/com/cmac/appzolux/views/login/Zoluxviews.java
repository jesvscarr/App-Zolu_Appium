package com.cmac.appzolux.views.login;

import com.igs.utils.MobileDriverDOM;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * Clase de la Activity com.cmac.appzolux/com.cmac.appzolux.ui.main.view.MainActivity
 */
public class Zoluxviews extends MobileDriverDOM {
	
	//BENEFICIOS
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.cmac.caja360:id/navigation_bar_item_small_label_view\" and @text=\"Beneficios\"]")
	private MobileElement BtnBeneficios;
	//PRODUCTIVIDAD
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.cmac.caja360:id/textView9\" and @text=\"Productividad\"]")
	private MobileElement BtnProductividad;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Analistas de Créditos\"]")
	private MobileElement BtnAnalistaCreditos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.cmac.caja360:id/txt_productivity_bono_title_1\" and @text=\"Datos del colaborador\"]")
	private MobileElement BtnDatosColaborador;

	//BENEFICIOS
	public void TapBeneficios() throws InterruptedException {
		Thread.sleep(2000);
		click(BtnBeneficios);
		Thread.sleep(2000);
	}
	
	//PRODUCTIVIDAD
	public void TapProductividad() throws InterruptedException {
		Thread.sleep(2000);
		try {
	           scrollToElement(BtnProductividad, "up");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		click(BtnProductividad);
		Thread.sleep(2000);
	}

	public void TapCreditos() throws InterruptedException  {
		Thread.sleep(2000);
		click(BtnAnalistaCreditos);
		Thread.sleep(2000);
		
	}

	public void TapDatosColaborador() throws InterruptedException  {
		
		Thread.sleep(2000);
		click(BtnDatosColaborador);
		Thread.sleep(2000);
		
	}

			
			@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Portal\n" + "de Normativa')]")
			private MobileElement BtnPortal;
			
			@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Portal\n" + "de Normativa')]")
			private MobileElement BtnPortal1;
						
			public void IngresoPortal()  throws InterruptedException {
				Thread.sleep(2000);
				try {
					scrollToElement(BtnPortal, "up");
				} catch (Exception e) {
					e.printStackTrace();
				}
				click(BtnPortal);
				Thread.sleep(2000);
						

				}

			public void Validacion() {
				// TODO Auto-generated method stub
				
			}

			//
			

			
			


			

						
						

						
}	
	
		
