
package ar.com.sosa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model correspondiente al Dashboard principal de OrangeHRM.
 * clase encapsula los elementos y acciones disponibles en el menú superior
 * luego de realizar un login exitoso.
 *
 * Funcionalidades cubiertas:
 * - Navegación hacia el módulo PIM.
 * - Acceso al menú de usuario y ejecución del logout.
 * - Validación de que el usuario se encuentra en el Dashboard.
 */

public class DashboardPage extends BasePage {

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By userDropdown = By.cssSelector("p.oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[text()='Logout']");
    private By header = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * goToPIM (Navega al módulo PIM)
     */
    public void goToPIM() {
        click(pimMenu);
    }

    /**
     * logout (Hace logout)
     */
    public void logout() {
        click(userDropdown);
        click(logoutButton);
    }

    /**
     * isOnDashboard (Verifica si estamos en el Dashboard)
     */
    public boolean isOnDashboard() {
        return isElementVisible(header);
    }

    /**
     * getHeaderText (Obtiene el header)
     */
    public String getHeaderText() {
        return getText(header);
    }
}