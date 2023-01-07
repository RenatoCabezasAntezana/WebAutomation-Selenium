package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class pagoPage extends util {
    @FindBy(id = "card_nmuber") protected WebElement txtTarjeta;
    @FindBy(id = "month") protected WebElement cmbMes;
    @FindBy(id = "year") protected WebElement cmbYear;
    @FindBy(id = "cvv_code") protected WebElement txtCVV;
    @FindBy(name="submit") protected WebElement btnPagar;

    public pagoPage() {
        PageFactory.initElements(driver,this);
    }

    public void escribirNumeroTarjeta(String texto){
        wait.until(ExpectedConditions.visibilityOf(txtTarjeta));
        txtTarjeta.sendKeys(texto); // ES MANDAMOS EL NUMERO DE TARJETA
    }

    public void seleccionarMes(String mes){
        new Select(cmbMes).selectByVisibleText(mes); //SELECCIONAR UN COMBOBOX
    }

    public void seleccionarAnio(String anio){
        new Select(cmbYear).selectByVisibleText(anio);
    }

    public void escribirCVV(String cvv){
        txtCVV.sendKeys(cvv);
    }

    public void pagarCompra(){
        btnPagar.click();
    }

}
