package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageClass {
    public PageClass(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//a[@id='employeeLink']")
    public WebElement manageEmployee;
    @FindBy(xpath = "//button[@onclick='modJs.renderForm();return false;']")
    public WebElement addNewEmployee;
    @FindBy(id="first_name")
    public WebElement firstName;
    @FindBy(id="last_name")
    public WebElement lastName;
    @FindBy(id="marital_status")  // select
    public WebElement maritalStatus;
    @FindBy(xpath = "//select[@id='employment_status']") // span
    public WebElement employmentStatus;

    @FindBy(xpath = "//select[@id='nationality']")
    public WebElement nationality;

    @FindBy(id="birthday")//input
    public WebElement DOB;
    @FindBy(xpath = "//select[@id = 'gender']")
    public WebElement gender;
    @FindBy(id = "joined_date")
    public WebElement joinDate;
    ////
    @FindBy(id="indirect_supervisors")
    public WebElement indirectSup;

    //////
    @FindBy (xpath = "//select[@id='job_title']")
    public WebElement jobTitle;
    @FindBy(xpath = "//select[@id='department']")
    public WebElement department;
    @FindBy (xpath = "//select[@id='country']")
    public WebElement country;
    @FindBy(id="employee_id")
    public WebElement employeeNum;
    @FindBy(xpath = "//div[@class='controls col-sm-9']/button[@class='saveBtn btn btn-primary pull-right']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@id='createUserModel']//button[.='No']")
    public WebElement no;
    @FindBy(xpath = "//button[@onclick='modJs.showFilters();return false;']")
    public WebElement filterButton;
    @FindBy(xpath = "(//select[@id='job_title'])[2]")
    public  WebElement jobTitleFilter;
    @FindBy(xpath = "//button[@class='filterBtn btn btn-primary pull-right']")
    public WebElement getFilterButtonClick;
    @FindBy(xpath = "//th[@aria-label='Employee Number: activate to sort column ascending']")
    public WebElement EmployeeOrderButton;
    @FindBy(xpath = "//td[@class=' sorting_1']")
    public List<WebElement> employeeList;

    @FindBy(xpath = "//img[@title='Edit' and @style='cursor:pointer;margin-left:15px;']")
    public List<WebElement> edit;
    @FindBy (xpath = "//th[@aria-label='First Name: activate to sort column ascending']")
    public  WebElement firstNameOrder;
    @FindBy(xpath = "//td[.='David']")
    public List<WebElement> david;
    @FindBy(id = "first_name")
    public WebElement firstNameChange;
    @FindBy(xpath = "//div[@class='controls col-sm-9']//button[@class='saveBtn btn btn-primary pull-right']")
    public  WebElement saveButtonFinal;



}
