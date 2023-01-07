package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class carritoPage extends util {
    @FindBy(name = "quantity") protected WebElement cmbcantidad;
    @FindBy(xpath = "//input[@type='submit']") protected WebElement btnpagar;

    public carritoPage() {
        PageFactory.initElements(driver,this);
    }

    public void seleccionarCantidad(String cantidad){
     wait.until(ExpectedConditions.visibilityOf(cmbcantidad)); //ESPERA QUE EL OBJETO ESTE VISIBLE
     new Select(cmbcantidad).selectByVisibleText(cantidad);
     //new Select(cmbcantidad).selectByValue(cantidad);
     //new Select(cmbcantidad).selectByIndex(2);
    }

    public void clickComprar(){
        wait.until(ExpectedConditions.elementToBeClickable(btnpagar));
        btnpagar.click();
    }
}
