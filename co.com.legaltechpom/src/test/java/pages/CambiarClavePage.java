package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representation of "Cambiar Contraseña" Page
 * </p>
 *
 * @author Álvaro López G.
 * @since 14/02/2020 1:16:22 p. m.
 * @version 1.0
 *
 */
public class CambiarClavePage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(id = "currentPassword")
  private WebElement txtClaveActual;

  @FindBy(id = "password")
  private WebElement txtNuevaClave;

  @FindBy(id = "confirmPassword")
  private WebElement txtConfirmarNuevaClave;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/main/div/main/div/div/div/div/div/span/form/div[2]/div/div[2]/button")
  private WebElement btnCambiarClave;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 14/02/2020 1:16:53 p. m.
   * @version 1.0
   */
  public CambiarClavePage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

  public void sendText(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

  public void clickAndSendText(WebElement element, String text) {
    element.click();
    element.clear();
    element.sendKeys(text);
  }

  public void completarCambioClaveFormulario(String claveActual, String nuevaClave, String confirmarClave)
      throws InterruptedException {
    // COMPLETAR FORMULARIO DE CAMBIO DE CLAVE
    clickAndSendText(txtClaveActual, claveActual);
    clickAndSendText(txtNuevaClave, nuevaClave);
    clickAndSendText(txtConfirmarNuevaClave, confirmarClave);
    Thread.sleep(1000);
    clickElement(btnCambiarClave);
  }

}
