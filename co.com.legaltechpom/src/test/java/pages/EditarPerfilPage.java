package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representation ot the "Editar Perfil" page for Legaltech
 * </p>
 *
 * @author Álvaro López G.
 * @since 14/02/2020 1:05:01 p. m.
 * @version 1.0
 *
 */
public class EditarPerfilPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(id = "firstName")
  private WebElement txtPrimerNombre;

  @FindBy(id = "middleName")
  private WebElement txtSegundoNombre;

  @FindBy(id = "firstSurname")
  private WebElement txtPrimerApellido;

  @FindBy(id = "middleSurname")
  private WebElement txtSegundoApellido;

  @FindBy(id = "contactNumber")
  private WebElement txtTelefonoContacto;

  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/main/div/main/div/div/div/div/div/span/form/div[2]/div/div[2]/button")
  private WebElement btnGuardarySalir;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 14/02/2020 1:09:27 p. m.
   * @version 1.0
   */
  public EditarPerfilPage(WebDriver webdriver) {
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

  public void clickAndSendText(WebElement element, String text) {
    element.click();
    element.sendKeys(text);
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

  public void editarPerfilFormulario(String nombre, String apellido, String telefono) throws InterruptedException {
    // Completar Formulario para editar perfil
    clickAndSendText(txtPrimerApellido, nombre);
    clickAndSendText(txtPrimerApellido, apellido);
    clickAndSendText(txtTelefonoContacto, telefono);
    Thread.sleep(1000);
    clickElement(btnGuardarySalir);
  }

}
