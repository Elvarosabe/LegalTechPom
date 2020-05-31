package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.EditarPerfilPage;
import pages.HomeOfficePage;
import pages.LoginPage;
import pages.PerfilPage;

public class EditarPerfil {

  private String PATHDRIVER = "src/test/resources/chromedriver/";
  private String baseURL = "http://3.221.30.207:8080/autenticacion/";
  WebDriver webdriver;

  // Datos iniciales login
  private String email = "alvaro.lopez@cadena.com.co";
  private String clave = "Cadena123*";

  private String nombre = "alvarete";
  private String apellido = "lopez";
  private String telefono = "3244345";

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
  public void EditarPerfilForm() throws InterruptedException {
    webdriver.get(baseURL);
    LoginPage loginPage = new LoginPage(webdriver);
    HomeOfficePage homeOfficePage = new HomeOfficePage(webdriver);
    PerfilPage perfilPage = new PerfilPage(webdriver);
    EditarPerfilPage editarPerfilPage = new EditarPerfilPage(webdriver);

    Thread.sleep(1000);
    loginPage.llenarFormularioLogin(email, clave);
    Thread.sleep(1000);
    if (homeOfficePage.isPageOpened("Generic Cadena/apps | Inicio")) {
      homeOfficePage.clickPerfil();
      Thread.sleep(1000);
      homeOfficePage.clickMiCuenta();
      Thread.sleep(1000);
      if (perfilPage.isPageOpened("Generic Cadena/apps | Mi perfil")) {
        perfilPage.clicEditarPerfil();
        Thread.sleep(1200);
        if (editarPerfilPage.isPageOpened("")) {
          editarPerfilPage.editarPerfilFormulario(nombre, apellido, telefono);
        } else {
          fail("La pagina de editar perfil no se cargo");
        }

      }
    }

  }

}
