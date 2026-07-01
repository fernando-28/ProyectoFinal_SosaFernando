# 🤖 Framework de Automatización — Java + Selenium + Cucumber

Framework de testing end-to-end construido con Java, Selenium WebDriver, Cucumber (BDD) y TestNG. 
Diseñado con el patrón Page Object Model (POM) para ser escalable y mantenible. 


# 🧰 Stack tecnológico

## Herramienta     	Versión
Java	            25
Selenium WebDriver	4.27.0
Cucumber        	7.18.0
TestNG          	7.8.0
Maven              	3.x


# 📌 Descripción del Proyecto

Este proyecto automatiza el flujo completo de OrangeHRM (Login exitoso,Buscar empleado,Flujo completo E2E).

## Utilizando:
Selenium WebDriver
Cucumber BDD
TestNG
Page Object Model
Hooks Before/After
Reportes HTML

El objetivo es validar funcionalidades críticas del sistema mediante escenarios BDD claros y mantenibles.

# 🧱 Estructura del Proyecto
ProyectoFinal_SosaFernando/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── ar.com.sosa.orangehrm.pages/
│   │           ├── BasePage.java
│   │           ├── DashboardPage.java
│   │           ├── LoginPage.java
│   │           └── PIMPage.java
│   └── test/
│       ├── java/
│       │   └── ar.com.sosa.orangehrm/
│       │       ├── pages/
│       │       ├── runner/
│       │       │   ├── Hooks.java
│       │       │   └── TestRunner.java
│       │       └── steps/
│       │           └── FlujoPrincipalSteps.java
│       └── resources/
│           └── features/
│               └── flujo_completo.feature
├── target/
│   ├── classes/
│   ├── generated-sources/
│   ├── generated-test-sources/
│   ├── test-classes/
│   ├── cucumber.json
│   └── cucumber-reports.html
├── .gitignore
├── pom.xml
├── README.md
└── testng.xml

# ⚙️ Setup

## Prerequisitos
Java JDK 25     instalado 
Maven 3.x       instalado
Google Chrome   instalado (versión actualizada)
IntelliJ IDEA 

# Dependencias utilizadas (pom.xml)

## Framework utiliza las siguientes librerías:
Selenium WebDriver                 — 4.21.0
WebDriverManager                   — 5.8.0
Cucumber Java                      — 7.18.1
Cucumber TestNG                    — 7.18.1
Cucumber Reporting (Masterthought) — 5.7.4
TestNG                             — 7.10.2

# Instalación
1. Clonar el repositorio
   git clone https://github.com/fernando-28/ProyectoFinal_SosaFernando.git
   **(Espero poder subirlo a github)** 

2. Entrar al directorio
   cd ProyectoFinal_SosaFernando

3. Instalar dependencias
   mvn clean install -DskipTests

4. Verificar versión de Java
   java -version
   Debe mostrar: openjdk version "25"

# Ejecutar el proyecto

### Desde IntelliJ
Abrir el proyecto
Panel Maven → Lifecycle → test
Click derecho → Run TestRunner

### Desde TestNG
### Desde testng.xml


# 📊 Reportes

## Reporte básico de Cucumber
Se genera en:
target/cucumber-reports.html

# 🐛 Troubleshooting

🔧 Error: module not found: org.seleniumhq.selenium.\*
Este error aparece cuando la versión de Selenium en el pom.xml no coincide con la que Maven intenta resolver.

<!-- ✅ Usar esta versión -->
<selenium.version>4.21.0</selenium.version>

# 📝 Escenarios

Los escenarios se escriben en Gherkin dentro de /resources/features/:
**flujo_completo.feature**

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

# 👤 Autor
Fernando Fabio Sosa  
Proyecto Final – QA Automation
Argentina, 2026


