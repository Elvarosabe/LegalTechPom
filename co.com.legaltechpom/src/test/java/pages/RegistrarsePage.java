package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representacion de la pagina para registrarse
 * </p>
 *
 * @author Álvaro López G.
 * @since 17/02/2020 1:41:33 p. m.
 * @version 1.0
 *
 */
public class RegistrarsePage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/main/div/div/div/div/div/span/form/div[1]/span/div/div/div[1]/div[1]")
  private WebElement tipoUsuarioBox;

  @FindBy(name = "firstName")
  private WebElement txtPrimerNombre;

  @FindBy(name = "middleName")
  private WebElement txtSegundoNombre;

  @FindBy(name = "firstSurname")
  private WebElement txtPrimerApellido;

  @FindBy(name = "middleSurname")
  private WebElement txtSegundoApellido;

  @FindBy(id = "identificationType")
  private WebElement tipoDocumentoBox;

  @FindBy(name = "identification")
  private WebElement txtNumeroDocumento;

  @FindBy(id = "email")
  private WebElement txtEmail;

  @FindBy(id = "contactNumber")
  private WebElement txtNumeroContacto;

  @FindBy(id = "password")
  private WebElement txtContrasena;

  @FindBy(id = "confirmPassword")
  private WebElement txtConfirmarContrasena;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/main/div/main/div/div/div/div/div/span/form/div[1]/div/div[3]/span[1]/div/div/div[1]/label")
  private WebElement aceptoTerminosCheck;

  @FindBy(id = "btnAcceptTerms")
  private WebElement btnAceptarTerminos;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/main/div/main/div/div/div/div/div/span/form/div[1]/div/div[3]/span[2]/div/div/div[1]/label")
  private WebElement aceptoTratamientoDatosCheck;

  @FindBy(id = "btnAcceptTerms")
  private WebElement btnAceptoTratamientoDatos;

  @FindBy(id = "btnRegisterSubscriber")
  private WebElement btnRegistrarse;

  @FindBy(id = "companyName")
  private WebElement txtNombreEmpresa;

  @FindBy(id = "companyTin")
  private WebElement txtNitEmpresa;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 17/02/2020 1:42:13 p. m.
   * @version 1.0
   */
  public RegistrarsePage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void registrarEmpresa(String nombreEmpresa, String nit, String primerNombre, String segundoNombre,
      String primerApellido, String segundoApellido, String nroDocumento, String telefono, String email,
      String contrasena, String confirmarContrasena) throws InterruptedException, AWTException {
    // TODO Auto-generated method stub
    clickElement(tipoUsuarioBox);
    Thread.sleep(1000);
    robotKeydown(0);
    Thread.sleep(800);
    clickAndSendText(txtNombreEmpresa, nombreEmpresa);
    Thread.sleep(200);
    clickAndSendText(txtNitEmpresa, nit);
    Thread.sleep(200);
    clickAndSendText(txtPrimerNombre, primerNombre);
    Thread.sleep(200);
    clickAndSendText(txtSegundoNombre, segundoNombre);
    Thread.sleep(200);
    clickAndSendText(txtPrimerApellido, primerApellido);
    Thread.sleep(200);
    clickAndSendText(txtSegundoApellido, segundoApellido);
    Thread.sleep(500);
    clickElement(tipoDocumentoBox);
    Thread.sleep(1000);
    robotKeydown(0);
    clickAndSendText(txtNumeroDocumento, nroDocumento);
    Thread.sleep(200);
    clickAndSendText(txtEmail, email);
    Thread.sleep(200);
    clickAndSendText(txtNumeroContacto, telefono);
    Thread.sleep(200);
    clickAndSendText(txtContrasena, contrasena);
    Thread.sleep(200);
    clickAndSendText(txtConfirmarContrasena, confirmarContrasena);
    Thread.sleep(500);
    clickElement(aceptoTerminosCheck);
    Thread.sleep(1200);
    clickElement(btnAceptarTerminos);
    Thread.sleep(300);
    clickElement(aceptoTratamientoDatosCheck);
    Thread.sleep(1000);
    clickElement(btnAceptoTratamientoDatos);
    Thread.sleep(1200);
    clickElement(btnRegistrarse);

  }

  public void registrarPersona(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
      String nroDocumento, String email, String telefono, String contrasena, String confirmarConrasena)
      throws InterruptedException, AWTException {
    clickElement(tipoUsuarioBox);
    Thread.sleep(1000);
    robotKeydown(1);
    Thread.sleep(500);
    clickAndSendText(txtPrimerNombre, primerNombre);
    Thread.sleep(200);
    clickAndSendText(txtSegundoNombre, segundoNombre);
    Thread.sleep(200);
    clickAndSendText(txtPrimerApellido, primerApellido);
    Thread.sleep(200);
    clickAndSendText(txtSegundoApellido, segundoApellido);
    Thread.sleep(500);
    clickElement(tipoDocumentoBox);
    Thread.sleep(1000);
    robotKeydown(0);
    clickAndSendText(txtNumeroDocumento, nroDocumento);
    Thread.sleep(200);
    clickAndSendText(txtEmail, email);
    Thread.sleep(200);
    clickAndSendText(txtNumeroContacto, telefono);
    Thread.sleep(200);
    clickAndSendText(txtContrasena, contrasena);
    Thread.sleep(200);
    clickAndSendText(txtConfirmarContrasena, confirmarConrasena);
    Thread.sleep(500);
    clickElement(aceptoTerminosCheck);
    Thread.sleep(1200);
    clickElement(btnAceptarTerminos);
    Thread.sleep(300);
    clickElement(aceptoTratamientoDatosCheck);
    Thread.sleep(1000);
    clickElement(btnAceptoTratamientoDatos);
    Thread.sleep(1200);
    clickElement(btnRegistrarse);

  }

  public void clickElement(WebElement element) {
    element.click();
  }

  public void sendText(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }

  public void clickAndSendText(WebElement element, String text) {
    element.click();
    element.sendKeys(text);
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

  /**
   * Simula acción de flecha abajo mediante el robot
   *
   *
   * @param cantidad
   * @author Álvaro López.
   * @version 1.0
   * @since 13/11/2019 9:36:41 a. m.
   */
  public void robotKeydown(Integer cantidad) throws AWTException {
    Robot robot = new Robot();
    for (int i = 0; i < cantidad + 1; i++) {
      robot.keyPress(KeyEvent.VK_DOWN);
      robot.keyRelease(KeyEvent.VK_DOWN);

    }
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
  }

}
