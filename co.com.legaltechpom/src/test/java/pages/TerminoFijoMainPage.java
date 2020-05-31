package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * <p>
 * Representation of fixed contracts page
 * </p>
 *
 * @author Álvaro López G.
 * @since 11/02/2020 2:08:51 p. m.
 * @version 1.0
 *
 */
public class TerminoFijoMainPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(xpath = "//*[@id=\"btnSelect5e20ba15de513eebdbe2a6f6\"]")
  private WebElement terminoFijoNatural;

  @FindBy(xpath = "//*[@id=\"btnSelect5e20ba15de513eebdbe2a6f6\"]")
  private WebElement terminoFijoJuridico;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 11/02/2020 2:20:47 p. m.
   * @version 1.0
   */
  public TerminoFijoMainPage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void clickNatural() {
    terminoFijoNatural.click();
  }

  public void clickJuridico() {
    terminoFijoJuridico.click();
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

}
