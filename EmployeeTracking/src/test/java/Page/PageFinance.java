package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageFinance {
    public PageFinance(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.='Finance']")
    public WebElement financeBtn;
    @FindBy(xpath = "//ul[@id='module_Finance']//i[@class='fa fa-calculator']")
    public WebElement salaryBtn;
    @FindBy(xpath = "//h1")
    public WebElement text;
    @FindBy(xpath = "//button[.='Add New ']")
    public WebElement addNewBtn;
    @FindBy(id = "component")
    public WebElement SalaryComponent;
    @FindBy(id="amount")
    public WebElement Amount;
    @FindBy(id = "details")
    public WebElement details;
    @FindBy(xpath = "//*[.=' Save']")
    public WebElement save;
    @FindBy (xpath = "//div[@id='grid_wrapper']//td[3]")
    public List<WebElement> listOfDetails;

}
