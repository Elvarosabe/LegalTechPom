package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representation of the HomeFrontOffice where you can choose to go to contracts or legal counseling
 * </p>
 *
 * @author Álvaro López G.
 * @since 11/02/2020 1:31:57 p. m.
 * @version 1.0
 *
 */
public class HomeOfficePage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/header/div/div[3]/div/a[1]")
  private WebElement contratosTab;

  @FindBy(linkText = " ÁREA JURÍDICA ")
  private WebElement areaJuridicaTab;

  @FindBy(linkText = " USUARIOS ")
  private WebElement usuariosTab;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/header/div/button")
  private WebElement perfilTab;

  @FindBy(id = "btn-profile")
  private WebElement micuentaLink;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 11/02/2020 1:32:54 p. m.
   * @version 1.0
   */
  public HomeOfficePage(WebDriver webdriver) {
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

  public void clickContratos() {
    clickElement(contratosTab);
  }

  public void clickAreaJuridica() {
    clickElement(areaJuridicaTab);
  }

  public void clickPerfil() {
    clickElement(perfilTab);
  }

  public void clickUsuarios() {
    clickElement(usuariosTab);
  }

  public void clickMiCuenta() {
    clickElement(micuentaLink);
  }

}
