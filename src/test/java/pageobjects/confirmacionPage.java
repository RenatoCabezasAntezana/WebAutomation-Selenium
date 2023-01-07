package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class confirmacionPage extends util {
    //@FindBy(xpath = "//*[text()='Payment successfull!']") protected WebElement lblMensaje;
    @FindBy(xpath = "//*[text()='Order ID']//preceding::h2") protected WebElement lblMensaje;
    // XPATH RELATIVO CON EL FOLLOWING TOMA COMO REFERENCIA AL ORDER ID Y CONTROLA AL SIGUIENTE
    @FindBy(xpath = "//*[text()='Order ID']//following::strong[1]") protected  WebElement lblOrderID;

    public confirmacionPage() {
        PageFactory.initElements(driver,this);
    }
    public void validarMensaje(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(lblMensaje));
        Assert.assertEquals(mensaje,lblMensaje.getText()); //VALIDACION MEDIANTE J-UNIT
    }
    public void mostrarCodigo(){
        System.out.println(lblOrderID.getText());
    }
}
