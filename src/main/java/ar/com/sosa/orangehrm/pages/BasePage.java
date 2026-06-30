package ar.com.sosa.orangehrm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * ============================================================
 * BASE PAGE - Clase base para todos los Page Objects
 * ============================================================
 *
 * DATA-DRIVEN TESTING
 *
 * Contiene Lo comun para todas las paginas:
 * - WebDriver y WebDriverWait
 * - Métodos genéricos: click(), type(), getText()
 * ============================================================
 */

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
    }

    /**
     * click (Hace click en un elemento)
     */
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * type (Escribe texto en un campo)
     */
    public void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    /**
     * * getText (Obtiene el texto de un elemento)
     */
    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    /**
     * isElementVisible (Verifica si un elemento está visible)
     */
    public boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * waitForUrlContains (Espera que la Url contenga un texto)
     */
    public void waitForUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }

    /**
     * waitForElementToDisappear (Espera a que un elemento desaparezca)
     */
    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}