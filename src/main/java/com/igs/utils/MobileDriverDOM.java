package com.igs.utils;

import com.igs.managers.GlobalParams;
import com.igs.managers.MobileDriverManager;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.net.URL;
import java.net.MalformedURLException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.Before;


/**
 * Clase para manipular Elementos en una vista
 */
    public class MobileDriverDOM {
    public AppiumDriver<?> driver;
    public TestUtils utils = new TestUtils();


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // Método para limpiar la caché de la aplicación
    public void clearAppCache() {
        try {
            String packageName = "com.google.android.apps.nexuslauncher"; // Reemplaza con el paquete de tu app
            Runtime.getRuntime().exec("adb shell pm clear " + packageName);
            System.out.println("Cache cleared for package: " + packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MobileDriverDOM() {
        this.driver = new MobileDriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("app", "/src/test/resources/apps/android/app-release.apk");
            capabilities.setCapability("appPackage", "com.zoluxiones.base_frontend");
            capabilities.setCapability("appActivity", ".MainActivity"); // Si no sabes el nombre exacto de la actividad, usa MainActivity o el nombre por defecto
            try {
                clearAppCache(); // Limpiar la caché antes de lanzar la app
                AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
                // Tu código de prueba aquí
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }

    }
    //

    // Este método espera la visibilidad de un elemento MobileElement
    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    
    // Este método espera la visibilidad de un elemento definido por By
    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    // Este método limpia el contenido de un MobileElement
    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    // Este método hace clic sobre un MobileElement
    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    // Este método hace clic sobre un MobileElement y nos permite ingresar un segundo parámetro como texto
    // que será mostrado en nuestro log.
    public void click(MobileElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }

    // Similar al método anterior, sólo que se usa para una variable tipo By (ById, ByXPath, etc.)
    public void click(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    // Envía ("escribe") un texto dentro en una variable tipo MobileElement
    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    // Envía ("escribe") un texto dentro en una variable tipo MobileElement y permite enviar un texto a
    // nuestro log de ejecución.
    public void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    // Obtiene el atributo de un MobileElement
    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    // Obtiene el atributo de una variable tipo By.
    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    /**
     * Obtiene el texto de una variable tipo MobileElement
     *
     * @param e   variable tipo By
     * @param msg Mensaje que enviaremos a nuestro log
     * @return Devuelve el texto del elemento que consultamos
     */
    public String getText(MobileElement e, String msg) {
        String txt;
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Valor inesperado: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    /**
     * Obtiene el texto de una variable tipo By
     *
     * @param e   variable tipo By
     * @param msg Mensaje que enviaremos a nuestro log
     * @return Devuelve el texto del elemento que consultamos
     */
    public String getText(By e, String msg) {
        String txt;
        switch (new GlobalParams().getPlatformName()) {
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Valor inesperado: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    /**
     * Método para cerrar la app
     */
    public void closeApp() {
        ((InteractsWithApps) driver).closeApp();
    }

    /**
     * Método para lanzar la app
     */
    public void launchApp() {
        ((InteractsWithApps) driver).launchApp();
    }

    /**
     * Método para hacer scroll en una vista de la app (Sólo para Android)
     *
     * @param childLocAttr
     * @param childLocValue
     * @return
     */
    public MobileElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
        return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector()." + childLocAttr + "(\"" + childLocValue + "\"));");
    }

    /**
     * Método para hacer scroll en una vista de la app (Sólo para iOS)
     *
     * @param e
     * @return
     */
    public MobileElement iOSScrollToElementUsingMobileScroll(MobileElement e) {
        RemoteWebElement element = ((RemoteWebElement) e);
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
        return e;
    }

    public By iOSScrollToElementUsingMobileScrollParent(MobileElement parentE, String predicateString) {
        RemoteWebElement parent = (RemoteWebElement) parentE;
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);
        scrollObject.put("predicateString", predicateString);
        driver.executeScript("mobile:scroll", scrollObject);
        By m = MobileBy.iOSNsPredicateString(predicateString);
        System.out.println("Mobilelement is " + m);
        return m;
    }

    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
    	 Dimension size = driver.manage().window().getSize();
         int startX = (int) (size.width * 0.5);
         int endX = (int) (size.width * 0.5);
         int startY = 0;
         int endY = 0;
         boolean isFound = false;

         switch (direction) {
             case "up":
                 endY = (int) (size.height * 0.5);
                 startY = (int) (size.height * 0.8);
                 break;

             case "down":
                 endY = (int) (size.height * 0.6);
                 startY = (int) (size.height * 0.4);
                 break;
         }

         for (int i = 0; i < 11; i++) {
             if (find(element, 1)) {
                 isFound = true;
                 break;
             } else {
                 swipe(startX, startY, endX, endY, 800);
             }
         }
         if (!isFound) {
             throw new Exception("Element not found");
         }
         return element;
    }

    public MobileElement scrollToElement3(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.8);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 9; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if (!isFound) {
            throw new Exception("Element not found");
        }
        return element;
    }
    
    public MobileElement scrollToElement4(MobileElement element, String direction) throws Exception {
   	 Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 8; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if (!isFound) {
            throw new Exception("Element not found");
        }
        return element;
   }
    
    public MobileElement scrollToElement2(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.6);
        int endX = (int) (size.width * 0.6);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.3);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.3);
                break;
        }

        for (int i = 0; i < 6; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if (!isFound) {
            throw new Exception("Element not found");
        }
        return element;
    }

    public By scrollToElement(By element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if (!isFound) {
            throw new Exception("Element not found");
        }
        return element;
    }

    public boolean find(final MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean find(final By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (driver.findElement(element).isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public void swipe(int startX, int startY, int endX, int endY, int millis)
            throws InterruptedException {
        TouchAction t = new TouchAction(driver);
        t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                .perform();
    }

    @Before
    public void setUp() {
        clearAppCache(); // Limpiar la caché antes de cada escenario
    }
}
