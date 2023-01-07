package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.*;

public class carritoDefinition {

    menuPage menu;
    tarjetaPage tarjeta;

    carritoPage carrito;

    pagoPage pago;

    confirmacionPage confirmacion;

    public carritoDefinition() {
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago = new pagoPage();
        confirmacion = new confirmacionPage();
    }

    @Given("que la web este operativa")
    public void queLaWebEsteOperativa() {
        hooks.driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @When("se genera el numero de tarjeta")
    public void seGeneraElNumeroDeTarjeta() {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.capturarNumeroTarjeta();
        tarjeta.capturarCVV();
        tarjeta.capturarFecha();
        tarjeta.ventanaPrincipal();
    }

    @Then("mostrar los valores")
    public void mostrarLosValores() {
    }

    @And("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cantidad) {
        carrito.seleccionarCantidad(cantidad);
    }

    @And("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @And("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() {
        pago.escribirNumeroTarjeta(tarjetaPage.nmr_tarjeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarAnio(tarjetaPage.anio);
        pago.escribirCVV(tarjetaPage.cvv_tarjeta);
    }

    @And("paga el producto")
    public void pagaElProducto() {
        pago.scrollVertical();
        pago.pagarCompra();
    }

    @Then("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) {
        confirmacion.validarMensaje(mensaje);
        confirmacion.mostrarCodigo();
    }
}
