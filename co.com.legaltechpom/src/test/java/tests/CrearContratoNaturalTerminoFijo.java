package tests;

import static org.junit.Assert.fail;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import pages.ContratosPage;
import pages.FijoNaturalFormPage;
import pages.HomeOfficePage;
import pages.LoginPage;
import pages.TerminoFijoMainPage;

public class CrearContratoNaturalTerminoFijo {

  private String PATHDRIVER = "src/test/resources/chromedriver/";
  private String baseURL = "http://3.221.30.207:8080/autenticacion/";
  WebDriver webdriver;

  // Datos iniciales login
  private String email = "telo@getnada.com";
  private String clave = "Cadena123*";

  // Datos Llenado de formulario
  private String nombreContrato = "Contratosky";
  private String nombreEmpleador = "TuCompany";
  private String idEmpleador = "200900300";
  private String ciudadEmpleador = "Medellín";
  private String deptoEmpleador = "Antioquia";
  private String salarioEmpleado = "5000000";
  private String duracionContrato = "2 años";
  private String cargoTrabajador = "Automatizacion Pruebas";
  private String periodoPrueba = "2 meses";
  private String nombreTrabajador = "Alvarito";
  private String idTrabajador = "1017206399";
  private String obligacionTrabajador = "Realizar automat de pruebas";
  private String yearSuscripcion = "2020";
  private String ciudadSubscripcion = "Medellín";
  private String obligacionEmpleador = "Pagar y brindar condiciones";
  private String ciudadServicios = "Medellín";
  private String deptoServicios = "Antioquia";

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", PATHDRIVER + "chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    webdriver = new ChromeDriver(options);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void crearContratoFijoNatural() throws InterruptedException, AWTException {
    webdriver.get(baseURL);
    LoginPage loginPage = new LoginPage(webdriver);
    HomeOfficePage homeOfficePage = new HomeOfficePage(webdriver);
    ContratosPage contratosPage = new ContratosPage(webdriver);
    TerminoFijoMainPage terminoFijoMainPage = new TerminoFijoMainPage(webdriver);
    FijoNaturalFormPage fijoNaturalFormPage = new FijoNaturalFormPage(webdriver);
    loginPage.llenarFormularioLogin(email, clave);
    Thread.sleep(1000);
    if (homeOfficePage.isPageOpened("Generic Cadena/apps | Inicio")) {
      homeOfficePage.clickContratos();
      Thread.sleep(600);
      if (contratosPage.isPageOpened("Generic Cadena/apps | Contratos")) {
        contratosPage.contratoTerminoFijoClick();
        Thread.sleep(600);
        if (terminoFijoMainPage.isPageOpened("Generic Cadena/apps | Lista de contratos por categoria")) {
          terminoFijoMainPage.clickNatural();
          Thread.sleep(1500);
          if (fijoNaturalFormPage.isPageOpened("Generic Cadena/apps | Diligenciamiento de contrato")) {
            fijoNaturalFormPage.llenarContratoNatural(nombreContrato, nombreEmpleador, idEmpleador, ciudadEmpleador,
                deptoEmpleador, salarioEmpleado, duracionContrato, cargoTrabajador, periodoPrueba, nombreTrabajador,
                idTrabajador, obligacionTrabajador, yearSuscripcion, ciudadSubscripcion, obligacionEmpleador,
                ciudadServicios, deptoServicios);
          } else {
            fail("El formulario de contrato natural a termino fijo no se cargó");
          }
        } else {
          fail("La vista de contratos por categoria fallo");
        }

      } else {
        fail("La vista de contratos fallo en cargarse");
      }

    } else {
      fail("La pagina principal fallo en cargarse");
    }

  }

}
