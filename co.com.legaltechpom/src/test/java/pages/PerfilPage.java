package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representation of Mi Perfil Page
 * </p>
 *
 * @author Álvaro López G.
 * @since 14/02/2020 11:35:38 a. m.
 * @version 1.0
 *
 */
public class PerfilPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(linkText = " Editar perfil ")
  private WebElement btnEditarPerfil;

  @FindBy(linkText = " Cambiar contraseña ")
  private WebElement btnCambiarClave;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/main/div/main/div/div/div/div/div/div/div[2]/div[2]/button")
  private WebElement btnAdministrarSuscripcion;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/main/div/main/div/div/div/div/div/div/div[2]/div[1]/div[6]/a")
  private WebElement linkHistorialPagos;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 14/02/2020 11:36:34 a. m.
   * @version 1.0
   */
  public PerfilPage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

  public void clicEditarPerfil() {
    btnEditarPerfil.click();
  }

  public void clicCambiarClave() {
    btnCambiarClave.click();
  }

  public void clicHistorialPagos() {
    linkHistorialPagos.click();
  }

  public void sendText(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

}
