package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <p>
 * LoginPage of LegalTech
 * </p>
 *
 * @author Álvaro López G.
 * @since 11/02/2020 1:11:31 p. m.
 * @version 1.0
 *
 */
public class LoginPage {

  WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(xpath = "//*[@id=\"email\"]")
  private WebElement txtEmail;

  @FindBy(id = "password")
  private WebElement txtClave;

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/main/div/div/div/div/div/span/form/div[2]/button")
  private WebElement btnIngresar;

  @FindBy(linkText = "REGISTRARSE")
  private WebElement registrarseLink;

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/main/div/div/div/div/div/span/form/div[1]/div/div[2]/a")
  private WebElement olvidoClaveLink;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 11/02/2020 1:11:56 p. m.
   * @version 1.0
   */
  public LoginPage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

  // Metodo generico para enviar texto a los input
  public void sendText(WebElement element, String text) {
    element.sendKeys(text);
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

  public void llenarFormularioLogin(String email, String clave) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(webdriver, 120);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
    clickElement(txtEmail);
    sendText(txtEmail, email);
    Thread.sleep(1000);
    clickElement(txtClave);
    sendText(txtClave, clave);
    clickElement(btnIngresar);

  }

  public void clickRegistrarse() {
    clickElement(registrarseLink);
  }

  public void clickOlvidoClave() {
    clickElement(olvidoClaveLink);
  }

}
