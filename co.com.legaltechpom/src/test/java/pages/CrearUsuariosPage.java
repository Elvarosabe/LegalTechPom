package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Creacion de usuarios asociados a empresa
 * </p>
 *
 * @author Álvaro López G.
 * @since 4/03/2020 8:01:50 a. m.
 * @version 1.0
 *
 */
public class CrearUsuariosPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  private WebElement txtPrimerNombre;

  private WebElement txtSegundoNombre;

  private WebElement txtPrimerApellido;

  private WebElement txtSegundoApellido;

  private WebElement tipoDocumentoBox;

  private WebElement txtNumeroDocumento;

  private WebElement txtEmail;

  private WebElement txtTelefonoContacto;

  private WebElement btnGuardarySalir;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 25/02/2020 2:33:47 p. m.
   * @version 1.0
   */
  public CrearUsuariosPage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public boolean isPageOpened(WebDriver webdriver, String title) {
    return webdriver.getTitle().contains(title);

  }

  public void clickAndSendText(WebElement element, String text) throws InterruptedException {
    element.click();
    element.sendKeys(text);
    Thread.sleep(1000);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

}
