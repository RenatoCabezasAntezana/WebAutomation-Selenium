
Feature: Funcionalidades del carrtio de compra

  Scenario: Compra de un producto
    Given que la web este operativa
    When se genera el numero de tarjeta
    And selecciona la cantidad "9"
    And realiza la compra del producto
    And ingresa los datos de la tarjeta
    And paga el producto
    Then validar el mensaje de pago "Payment successfull!"


  Scenario Outline: Compra de un producto con varias cantidades
    Given que la web este operativa
    When se genera el numero de tarjeta
    And selecciona la cantidad "<cantidad>"
    And realiza la compra del producto
    And ingresa los datos de la tarjeta
    And paga el producto
    Then validar el mensaje de pago "<mensaje>"
    Examples: Tabla de cantidades
      | cantidad | mensaje              |
      | 2        | Payment successfull! |
      | 3        | Payment successfull! |
      | 8        | Payment fail!        |