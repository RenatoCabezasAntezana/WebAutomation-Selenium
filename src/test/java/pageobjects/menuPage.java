package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class menuPage extends util {
    @FindBy(linkText = "Generate Card Number") protected WebElement lnkGenerarTarjeta;
    @FindBy(css = "#nav > a:nth-child(2)") private WebElement getLnkGenerarTarjeta2;
    @FindBy(xpath = "//nav/a[@href='cardnumber.php']") public  WebElement getGetLnkGenerarTarjeta3;

    public menuPage() {
        PageFactory.initElements(driver,this); // LO LLAMAMOS DE LA CLASE UTIL
    }
    public void clickGenerarTarjeta(){

        //VA A ESPERAR QUE EL ELEMENTO ESTE CLICKABLE EN LA PANTALLA POR 30 SEGUNDOS
        wait.until(ExpectedConditions.elementToBeClickable(getLnkGenerarTarjeta2));
        // SI EL ELEMENTO ESTA DISPONIBLE LE HACE CLICK
        getLnkGenerarTarjeta2.click();

    }
}
