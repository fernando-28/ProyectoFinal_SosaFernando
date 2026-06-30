package ar.com.sosa.orangehrm.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * * ============================================================
 *  * TEST RUNNER - Configuración de Cucumber con TestNG
 *  * ============================================================
 * Runner de Cucumber que ejecuta los escenarios definidos en los features.
 * Configura los plugins de reporte y la ubicación de los archivos.
 */

@CucumberOptions(
        // ============================================================
        // features: Ubicación de los archivos .feature
        // ============================================================
        features = "src/test/resources/features",

        // ============================================================
        // glue: Ubicación de Steps y Hooks
        // (adaptado a tu estructura real)
        // ============================================================
        glue = {
                "ar.com.sosa.orangehrm.steps",
                "ar.com.sosa.orangehrm.runner"
        },

        // ============================================================
        // plugin: Formato de los reportes
        // ============================================================
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },

        // ============================================================
        // monochrome: Formato de consola
        // ============================================================
        monochrome = true,

        // ============================================================
        // tags: Filtrar qué Scenarios ejecutar (opcional)
        // ============================================================
        tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {

        /**
         * Permite que cada fila de Examples
         * se ejecute como un test separado en TestNG.
         */
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}