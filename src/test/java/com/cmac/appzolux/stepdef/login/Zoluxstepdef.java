package com.cmac.appzolux.stepdef.login;

import com.cmac.appzolux.views.login.Zoluxviews;
import static org.junit.Assert.assertEquals;


import io.cucumber.java.en.And;

public class Zoluxstepdef {
	  
    Zoluxviews cajaZolux= new Zoluxviews();
	  //
	  @And("Ingreso a portal normativa") 
	  public void IngresoPortalNormativa() throws InterruptedException{
		  cajaZolux.IngresoPortal();
		  
	  }
		  

}
