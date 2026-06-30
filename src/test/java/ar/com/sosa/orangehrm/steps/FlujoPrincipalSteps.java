package ar.com.sosa.orangehrm.steps;

import ar.com.sosa.orangehrm.pages.LoginPage;
import ar.com.sosa.orangehrm.pages.DashboardPage;
import ar.com.sosa.orangehrm.pages.PIMPage;
import ar.com.sosa.orangehrm.runner.Hooks;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

public class FlujoPrincipalSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    public FlujoPrincipalSteps() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.pimPage = new PIMPage(driver);
    }

    // Background
    @Given("que estoy en la página de Login")
    public void queEstoyEnLaPaginaDeLogin() {
        loginPage.goTo();
    }

    // Scenario: Login exitoso
    @When("ingreso credenciales válidas")
    public void ingresoCredencialesValidas() {
        loginPage.loginAs("Admin", "admin123");
    }

    //  Nuevo

    // Steps nuevos para Login detallado
    @When("ingreso el usuario {string}")
    public void ingresoElUsuario(String usuario) {
        loginPage.ingresarUsuario(usuario);
    }

    @When("ingreso la contraseña {string}")
    public void ingresoLaContraseña(String password) {
        loginPage.ingresarPassword(password);
    }

    @When("hago click en el botón Login")
    public void hagoClickEnElBotonLogin() {
        loginPage.clickLogin();
    }

    // Nueno


    @Then("veo el Dashboard correctamente")
    public void veoElDashboardCorrectamente() {
        assert dashboardPage.isOnDashboard();
    }

    // Scenario: Buscar empleado
    @Given("navego al módulo PIM")
    public void navegoAlModuloPIM() {
        dashboardPage.goToPIM();
        assert pimPage.isOnPIMPage();
    }

    @When("busco al empleado {string}")
    public void buscoAlEmpleado(String nombre) {
        pimPage.searchEmployeeByName(nombre);
    }

    @Then("veo resultados en la grilla")
    public void veoResultadosEnLaGrilla() {
        assert pimPage.hasResults() || pimPage.isNoRecordsDisplayed();
    }

    // Scenario: Flujo completo E2E
    @When("hago logout")
    public void hagoLogout() {
        dashboardPage.logout();
    }

    @Then("vuelvo a la página de Login")
    public void vuelvoALaPaginaDeLogin() {
        assert loginPage.isOnLoginPage();
    }
}