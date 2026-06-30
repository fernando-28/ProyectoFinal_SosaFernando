package ar.com.sosa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ============================================================
 * LOGIN PAGE - Page Object para la página de login
 * ============================================================
 *
 *
 * Este Page Object será utilizado por los Step Definitions
 * para ejecutar las acciones de login definidas en Gherkin.
 *
 * URL: https://opensource-demo.orangehrmlive.com/
 * ============================================================
 */



public class LoginPage extends BasePage {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");

    /**
     * Navega a la página de login.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * goTo (Navega a la página Login)
     * */
    public void goTo() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    /**
     * Ingresa el nombre de usuario.
     * enterUserName (Ingresa el usuario)
     */
    public void enterUserName(String user) {
        type(usernameField, user);
    }

    /**
     * Ingresa la contraseña.
     * enterPassword (Ingresa la contraseña)
     */
    public void enterPassword(String pass) {
        type(passwordField, pass);
    }

    /**
     * Realiza el intento de login con usuario y contraseña.
     * loginAs (Metodo de alto nivel: login completo)
     */
    public void loginAs(String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        click(loginButton);
    }



    /**
     * Métodos nuevos para Steps detallados
     */
    public void ingresarUsuario(String user) {
        enterUserName(user); // reutilizamos  método existente
    }

    public void ingresarPassword(String pass) {
        enterPassword(pass); // reutilizamos  método existente
    }

    public void clickLogin() {
        click(loginButton); // reutilizamos  método existente
    }


    /**
     * Verifica si estamos en la página de login.
     * isOnLoginPage (Verifica si estamos en la página login)
     */
    public boolean isOnLoginPage() {
        return isElementVisible(loginButton);
    }

    /**
     * Obtiene el texto del mensaje de error.
     * isErrorDisplayed (Verifica si hay mensaje de error)
     */
    public boolean isErrorDisplayed() {
        return isElementVisible(errorMessage);
    }
}
