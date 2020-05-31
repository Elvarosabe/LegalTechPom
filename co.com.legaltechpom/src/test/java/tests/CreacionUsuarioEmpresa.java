package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.AdministracionUsuariosPage;
import pages.CrearUsuariosPage;
import pages.HomeOfficePage;
import pages.LoginPage;

public class CreacionUsuarioEmpresa {

  private String PATHDRIVER = "src/test/resources/chromedriver/";
  private String baseURL = "http://3.221.30.207:8080/autenticacion/";
  WebDriver webdriver;

  // Datos iniciales login de usuario Administrador Empresa
  private String email = "camilo.rivera@cadena.com.co";
  private String clave = "Cadena123*";

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
  public void creacionUsuarioEmpresa() {
    webdriver.get(baseURL);
    LoginPage loginPage = new LoginPage(webdriver);
    HomeOfficePage homeOfficePage = new HomeOfficePage(webdriver);
    AdministracionUsuariosPage administracionUsuariosPage = new AdministracionUsuariosPage(webdriver);
    CrearUsuariosPage crearUsuariosPage = new CrearUsuariosPage(webdriver);
  }

}
