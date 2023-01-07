package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks {
    public static WebDriver driver;

    @Before
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(); //inicializamos driver, va a abrir el navegador
        driver.manage().window().maximize(); // MAXIMIZA LA VENTANA QUE CORRESPONDE A LA VARIABLE DRIVER (CRHOME)
    }

    @After
    public static void tearDown(){
        driver.manage().deleteAllCookies(); //BORRAR TODAS LAS COOCKIES Y A LA VEZ CIERRA EL NAVEGADOR
        driver.close(); //CERRAR EL NAVEGADOR DEL CHROME
    }
}
