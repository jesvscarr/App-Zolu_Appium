Feature: ingresamos a la aplicacion login Zoluxiones


  @login
  Scenario: Ingresar al login Zoluxiones
     Given ingreso al aplicacion con usuario "prueba" y contrasenia "prueba"
     And hago tap en el boton ingresar
     Then valido vista Empleados ""

    
