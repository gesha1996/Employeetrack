package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Payrollpage {
    public Payrollpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Payroll']")
    public WebElement payrollBtn;
    @FindBy(xpath = "//a[@href='http://icehrm-open.gamonoid.com/?g=admin&n=salary&m=admin_Payroll']")
    public WebElement salaryBtn;
    @FindBy(xpath = "//a[@id='tabEmployeeSalary']")
    public WebElement employeeComponents;
    @FindBy(xpath = "//button[.='Filter ']")
    public WebElement filterBtn;
    @FindBy(xpath = "//div[@id='field_employee']//span[@class='select2-arrow']")
    public WebElement arrow;
    @FindBy(id = "employee")
    public WebElement taylorHolmes;
    @FindBy(xpath = "//button[@class='filterBtn btn btn-primary pull-right']")
    public WebElement filter;
    @FindBy(xpath = "(//td[.='10000000.00'])[1]/..//td")
    public List<WebElement> finalList;
}
