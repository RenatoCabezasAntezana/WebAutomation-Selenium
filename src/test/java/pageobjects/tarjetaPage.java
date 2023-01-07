package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class tarjetaPage extends util {

    public static String nmr_tarjeta;
    public static String cvv_tarjeta;
    public static String anio;

    public static String mes;




    @FindBy(xpath="//*[contains(text(),'Card Number:')]") protected WebElement cardNumber;
    @FindBy(xpath = "//*[contains(text(),'CVV:')]") protected  WebElement cvv;
    @FindBy(xpath = "//*[contains(text(),'Exp:')]") protected  WebElement fechaExp;

    public tarjetaPage() {
        PageFactory.initElements(driver,this);
    }
    public void capturarNumeroTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(cardNumber));
        String texto = cardNumber.getText();
        nmr_tarjeta=texto.replace("Card Number:-","");
        System.out.println(nmr_tarjeta);
    }
    public void capturarCVV(){
        String texto = cvv.getText();
        cvv_tarjeta = texto.replace("CVV:-","");
        System.out.println(cvv_tarjeta);
    }
    public void capturarFecha(){
        String texto = fechaExp.getText();
        String fecha[] = texto.replace("Exp:-","").split("/");
        mes = fecha[0];
        anio = fecha[1];
        System.out.println(mes);
        System.out.println(anio);
    }
}
