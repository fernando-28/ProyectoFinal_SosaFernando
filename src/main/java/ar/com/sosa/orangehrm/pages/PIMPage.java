package ar.com.sosa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage {

    private By employeeNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resultRows = By.cssSelector(".oxd-table-body .oxd-table-card");
    private By noRecordsLabel = By.xpath("//span[text()='No Records Found']");
    private By tableBody = By.cssSelector(".oxd-table-body");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    /**
     * searchEmployeeByName (Busca empleado por nombre)
     */
    public void searchEmployeeByName(String name) {
        clear(employeeNameField);               // Limpia el campo antes de escribir
        type(employeeNameField, name);          // Escribe el nombre
        click(searchButton);                    // Click en Search

        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        waitForTableToLoad();                   // Espera a que la tabla se actualice
    }

    private void waitForTableToLoad() {
        try {
            Thread.sleep(800); // Pequeña espera para que la tabla refresque
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * hasResults (verifica si no hay resultados)
     */
    public boolean hasResults() {
        return driver.findElements(resultRows).size() > 0;
    }

    /**
     * isNoRecordsDisplayed (verifica si no hay resultados)
     */
    public boolean isNoRecordsDisplayed() {
        return isElementVisible(noRecordsLabel);
    }

    /**
     * isOnPIMPage (Verifica si estamos en PIM Page)
     */
    public boolean isOnPIMPage() {
        return isElementVisible(searchButton);
    }
}