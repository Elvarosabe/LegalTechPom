package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Administracion de los usuarios a crear asociados a empresa
 * </p>
 *
 * @author Álvaro López G.
 * @since 4/03/2020 8:01:12 a. m.
 * @version 1.0
 *
 */
public class AdministracionUsuariosPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(id = "btnUsersManagementAdd")
  private WebElement btnCrearUsuario;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 25/02/2020 2:32:05 p. m.
   * @version 1.0
   */
  public AdministracionUsuariosPage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void clickCrearUsuario() {
    btnCrearUsuario.click();
  }

  public boolean isPageOpened(WebDriver webdriver, String title) {
    return webdriver.getTitle().contains(title);

  }

}
