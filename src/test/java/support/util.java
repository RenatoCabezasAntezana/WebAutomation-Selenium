package support;
import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class util extends hooks{
    public static WebDriverWait wait; // TIEMPO DE ESPERA DE LA PAGINA WEB
    public static JavascriptExecutor js;

    // CONSTRUCTOR
    public util() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(30000));
        js = (JavascriptExecutor) driver;
    }

    //METODOS GENERICOS
    public void ventanaActiva(){
        Set<String> identificadores = driver.getWindowHandles(); //OBTENEMOS TODOS LOS IDENTIFICADORES DE LA AUTOMAT.
        for (String identificador:identificadores){
            //OBTENGO TODOS LOS IDENTIFICADORES Y LUEGO RECORRO EL NUMERO DE VECES AL NUMERO DE VENTANAS ABIERTAS, LUEGO LE DIGO QUE
            // SE POSICIONE EN LA ULTIMA VENTANA ABIERTA
            driver.switchTo().window(identificador);
        }
    }

    public void ventanaPrincipal(){
        driver.close();
        driver.switchTo().window(""); // REGRESA A LA VENTANA INICIAL
    }

    public void scrollVertical(){
        js.executeScript("window.scrollBy(0,1000)");
    }
    public static void evidencias() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_KKmmssSSS");
        //RUTA DONDE SE GUARDARAN LAS EVIDENCIAS
        String path = "C:Proyectos/WebAutomation/target/evidencias/";
        String nombre = formato.format(fecha)+"_evidencia.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // TOMA LA CAPTURA DE EVIDENCIA
        FileUtils.copyFile(file, new File(path+nombre)); // CREA LA EVIDENCIA DENTRO DE LA RUTA PATH CON EL NOMBRE EVIDENCIA.JPG
    }
}
