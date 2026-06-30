package ar.com.sosa.orangehrm.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Hooks de Cucumber  ejecuta acciones antes y después de cada escenario.
 * Inicialización y cierre del WebDriver.
 */

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {

        System.out.println("\n========================================");
        System.out.println("INICIANDO ESCENARIO: " + scenario.getName());
        System.out.println("========================================\n");

        // Configurar ChromeDriver automáticamente
        WebDriverManager.chromedriver().setup();

        // Configurar Opciones de Chrome
        ChromeOptions options = new ChromeOptions();

        // Deshabilitar pantalla de selección de buscador
        options.addArguments("--disable-search-engine-choice-screen");

        // Deshabilitar notificaciones
        options.addArguments("--disable-notifications");

        // Deshabilitar barra de información
        options.addArguments("--disable-infobars");

        // Permitir orígenes remotos (evita errores de CORS)
        options.addArguments("--remote-allow-origins=*");

        // Preferencias experimentales
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        // Crear driver con opciones
        driver = new ChromeDriver(options);

        // Maximizar ventana
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {

        // Mostrar resultado del escenario
        if (scenario.isFailed()) {
            System.out.println("\n❌ ESCENARIO FALLÓ: " + scenario.getName());
        } else {
            System.out.println("\n✅ ESCENARIO PASÓ: " + scenario.getName());
        }

        System.out.println("========================================\n");

        // Cerrar navegador
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}