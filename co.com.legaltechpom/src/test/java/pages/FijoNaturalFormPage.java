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
 * Representa el formulario de contrato termino fijo Natural
 * </p>
 *
 * @author Álvaro López G.
 * @since 2/03/2020 8:26:16 a. m.
 * @version 1.0
 *
 */
public class FijoNaturalFormPage {

  private WebDriver webdriver;

  // LOCALIZADORES

  @FindBy(id = "legalDocumentCustomName")
  private WebElement txtNombreContrato;

  @FindBy(id = "employer")
  private WebElement txtNombreEmpleador;

  @FindBy(id = "numDocumentEmployer")
  private WebElement txtIdentificacionEmpleador;

  @FindBy(id = "primaryResidenceEmployer")
  private WebElement txtCiudad;

  @FindBy(id = "mainDepartmentResidence")
  private WebElement txtDepartamento;

  @FindBy(id = "salaryEmployee")
  private WebElement txtSalario;

  @FindBy(id = "wayPayment")
  private WebElement formaPagoBox;

  @FindBy(id = "contractDuration")
  private WebElement txtDuracionContrato;

  @FindBy(id = "workerPosition")
  private WebElement txtCargoTrabajador;

  @FindBy(id = "trialPeriod")
  private WebElement txtPeriodoPrueba;

  @FindBy(id = "workerName")
  private WebElement txtTrabajador;

  @FindBy(id = "numDocumentEmploye")
  private WebElement txtIdentificacionTrabajador;

  @FindBy(id = "homework_0")
  private WebElement txtObligacionesTrabajador;

  @FindBy(id = "signatureDay")
  private WebElement diaBox;

  @FindBy(id = "signatureMonth")
  private WebElement mesBox;

  @FindBy(id = "signatureYear")
  private WebElement txtYear;

  @FindBy(id = "signatureCity")
  private WebElement txtCiudadContrato;

  @FindBy(id = "contractingObligations_0")
  private WebElement txtObligacionEmpleador;

  @FindBy(id = "workHeadquartersCity")
  private WebElement txtCiudadServicios;

  @FindBy(id = "workHeadquartersDepartment")
  private WebElement txtDepartamentoServicios;

  @FindBy(id = "btnVisualizeLegalDocument")
  private WebElement btnVisualizar;

  /**
   * Constructor
   *
   * @param webdriver
   *
   * @author Álvaro López G.
   * @since 2/03/2020 8:29:00 a. m.
   * @version 1.0
   */
  public FijoNaturalFormPage(WebDriver webdriver) {
    this.webdriver = webdriver;
    PageFactory.initElements(webdriver, this);
  }

  public void clickAndText(WebElement element, String text) throws InterruptedException {
    element.click();
    element.sendKeys(text);
    Thread.sleep(300);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

  public boolean isPageOpened(String title) {
    return webdriver.getTitle().contains(title);
  }

  public void llenarContratoNatural(String nombreContrato, String nombreEmpleador, String idEmpleador,
      String ciudadEmpleador, String deptoEmpleador, String salarioEmpleado, String duracionContrato,
      String cargoTrabajador, String periodoPrueba, String nombreTrabajador, String idTrabajador,
      String obligacionTrabajador, String yearSuscripcion, String ciudadSubscripcion, String obligacionEmpleador,
      String ciudadServicios, String deptoServicios) throws InterruptedException, AWTException {

    clickAndText(txtNombreContrato, nombreContrato);
    clickAndText(txtNombreEmpleador, nombreEmpleador);
    clickAndText(txtIdentificacionEmpleador, idEmpleador);
    clickAndText(txtCiudad, ciudadEmpleador);
    clickAndText(txtDepartamento, deptoEmpleador);
    clickAndText(txtSalario, salarioEmpleado);
    clickElement(formaPagoBox);
    Thread.sleep(500);
    robotKeydown(1);
    Thread.sleep(1000);
    clickAndText(txtDuracionContrato, duracionContrato);
    clickAndText(txtCargoTrabajador, cargoTrabajador);
    clickAndText(txtPeriodoPrueba, periodoPrueba);
    clickAndText(txtTrabajador, nombreTrabajador);
    clickAndText(txtIdentificacionTrabajador, idTrabajador);
    clickAndText(txtObligacionesTrabajador, obligacionTrabajador);
    clickElement(diaBox);
    Thread.sleep(500);
    robotKeydown(0);
    Thread.sleep(1000);
    clickElement(mesBox);
    Thread.sleep(500);
    robotKeydown(10);
    Thread.sleep(1000);
    clickAndText(txtYear, yearSuscripcion);
    clickAndText(txtCiudadContrato, ciudadSubscripcion);
    clickAndText(txtObligacionEmpleador, obligacionEmpleador);
    clickAndText(txtCiudadServicios, ciudadServicios);
    clickAndText(txtDepartamentoServicios, deptoServicios);

    clickElement(btnVisualizar);
    Thread.sleep(1000);

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
