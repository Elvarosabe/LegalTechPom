package tests;

import static org.junit.Assert.fail;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;
import pages.RegistrarsePage;

public class RegistrarPersona {

  private String PATHDRIVER = "src/test/resources/chromedriver/";
  private String baseURL = "http://3.221.30.207:8080/autenticacion/";
  WebDriver webdriver;

  // DATOS PARA LLENADO DE FORMULARIO PERSONA
  String primerNombre = "Prueba";
  String segundoNombre = "place";
  String primerApellido = "to";
  String segundoApellido = "pay";
  String nroDocumento = "1029839450";
  String email = "telo@getnada.com";
  String telefono = "2345676";
  String contrasena = "Cadena123*";
  String confirmarConrasena = "Cadena123*";

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", PATHDRIVER + "chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    webdriver = new ChromeDriver(options);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void registrarPersona() throws InterruptedException, AWTException {
    webdriver.get(baseURL);
    LoginPage loginPage = new LoginPage(webdriver);
    RegistrarsePage registrarsePage = new RegistrarsePage(webdriver);
    loginPage.clickRegistrarse();
    Thread.sleep(1500);
    if (registrarsePage.isPageOpened("Generic Cadena/apps | Registrarse")) {
      registrarsePage.registrarPersona(primerNombre, segundoNombre, primerApellido, segundoApellido, nroDocumento,
          email, telefono, contrasena, confirmarConrasena);
    } else {
      fail("La pagina de registrarse no se cargo");
    }

  }
}
