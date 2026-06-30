# ============================================================
# Feature: Flujo completo en OrangeHRM
# ============================================================


Feature: Flujo completo en OrangeHRM
  Como usuario administrador
  Quiero realizar un flujo E2E en OrangeHRM
  Para validar el correcto funcionamiento del sistema

  Background:
    Given que estoy en la página de Login


  Scenario: Login exitoso
     When ingreso el usuario "Admin"
     And ingreso la contraseña "admin123"
     And hago click en el botón Login
     Then veo el Dashboard correctamente

  Scenario: Buscar empleado
    Given ingreso credenciales válidas
    And navego al módulo PIM
    When busco al empleado "John"
    Then veo resultados en la grilla

  Scenario: Flujo completo E2E
    When ingreso credenciales válidas
    And navego al módulo PIM
    And busco al empleado "John"
    And hago logout
    Then vuelvo a la página de Login