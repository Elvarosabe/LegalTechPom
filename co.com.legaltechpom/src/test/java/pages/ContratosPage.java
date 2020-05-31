package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representation of contracts page
 * </p>
 *
 * @author Álvaro López G.
 * @since 11/02/2020 1:48:50 p. m.
 * @version 1.0
 *
 */
public class ContratosPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(id = "btnSearch")
  private WebElement txtBuscarContactos;

  @FindBy(id = "btnCategory12312")
  private WebElement btnContratosTerminoFijo;

  @FindBy(id = "btnCategory1231")
  private WebElement btnAlquilar;

  @FindBy(id = "btnCategory4525")
  private WebElement btnServicios;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 11/02/2020 1:49:21 p. m.
   * @version 1.0
   */
  public ContratosPage(WebDriver webdriver) {
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

  public void buscarContratos(String contratos) {
    clickElement(txtBuscarContactos);
    sendText(txtBuscarContactos, contratos);
  }

  public void contratoTerminoFijoClick() {
    clickElement(btnContratosTerminoFijo);
  }

  public void alquilarClick() {
    clickElement(btnAlquilar);
  }

  public void serviciosClick() {
    clickElement(btnServicios);
  }

}
