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

public class RegistrarEmpresa {

  private String PATHDRIVER = "src/test/resources/chromedriver/";
  private String baseURL = "http://3.221.30.207:8080/autenticacion/";
  WebDriver webdriver;

  private String nombreEmpresa = "Johnie Walker";
  private String nit = "3003003";
  private String primerNombre = "Juan";
  private String segundoNombre = "Pablo";
  private String primerApellido = "Raba";
  private String segundoApellido = "nose";
  private String nroDocumento = "34333342";
  private String email = "hawat@getnada.com";
  private String telefono = "3333333";
  private String contrasena = "Cadena123*";
  private String confirmarContrasena = "Cadena123*";

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
  public void registrarEmpresa() throws InterruptedException, AWTException {
    webdriver.get(baseURL);
    LoginPage loginPage = new LoginPage(webdriver);
    RegistrarsePage registrarsePage = new RegistrarsePage(webdriver);
    loginPage.clickRegistrarse();
    if (registrarsePage.isPageOpened("Generic Cadena/apps | Registrarse")) {
      registrarsePage.registrarEmpresa(nombreEmpresa, nit, primerNombre, segundoNombre, primerApellido, segundoApellido,
          nroDocumento, telefono, email, contrasena, confirmarContrasena);
    } else {
      fail("La pagina de registrar no se cargó");
    }
  }

}
