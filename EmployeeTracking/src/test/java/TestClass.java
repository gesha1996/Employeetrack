import Page.PageClass;
import Test.TestBase;
import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class TestClass extends TestBase {
    PageClass page;
    SoftAssert softAssert;

    @DataProvider(name = "employee")
    public Object[][] addEmployee() {

        return new Object[][]
                {
                        {getRandomString(), "David", "Lee", "Albanian", "1992/04/02", "Male", "Married", "Full Time Internship", "Software Engineer", "Albania", "2020/05/05", "Development Team", "Sofia O'Sullivan"},
                        {getRandomString(), "Robert", "Smith", "American", "1999/08/03", "Male", "Single", "Full Time Permanent", "Software Engineer", "United States", "2019/04/04", "Development Team", "Sofia O'Sullivan"},
                        {getRandomString(), "Maria", "Garcia", "Canadian", "2000/10/05", "Female", "Divorced", "Part Time Internship", "Software Engineer", "Canada", "2018/03/03", "Development Team", "Sofia O'Sullivan"},
                        {getRandomString(), "Jennifer", "Zack", "Cuban", "2001/11/08", "Female", "Married", "Part Time Permanent", "Software Engineer", "Cuba", "2017/02/02", "Development Team", "Sofia O'Sullivan"},
                        {getRandomString(), "James", "Anderson", "Gambian", "2004/03/04", "Male", "Single", "Full Time Permanent", "Software Engineer", "Gambia", "2016/08/08", "Development Team", "Sofia O'Sullivan"}};
    }

    @BeforeTest
    public void setup() {
        page = new PageClass(driver);
        softAssert = new SoftAssert();
        driver.get("http://icehrm-open.gamonoid.com/login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.username.sendKeys("admin");
        page.password.sendKeys("admin" + Keys.ENTER);
        page.manageEmployee.click();
        page.addNewEmployee.click();
    }

    @Test(dataProvider = "employee")
    public void mainTest(String employeeNum, String name, String lastName, String nationality, String dob,
                         String gender, String maritalStatus, String employeeStatus, String jobTitle, String country, String joinDate, String department, String indirectSupervisor) throws InterruptedException {

        driver.navigate().refresh();
        page.addNewEmployee.click();
        page.employeeNum.sendKeys(employeeNum);
        page.firstName.sendKeys(name);
        page.lastName.sendKeys(lastName);
        select(page.nationality, nationality);
        page.DOB.sendKeys(dob);
        select(page.gender, gender);
        select(page.maritalStatus, maritalStatus);
        select(page.employmentStatus, employeeStatus);
        select(page.jobTitle, jobTitle);
        select(page.country, country);
        page.joinDate.sendKeys(joinDate);
        BrowserUtils.scrollDown(0, 500);
        select(page.department, department);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        select(page.indirectSup, indirectSupervisor);
        Thread.sleep(1000);
        page.saveButton.click();

        page.no.click();
    }

    @Test(dependsOnMethods = "mainTest")
    public void filter() throws InterruptedException, IOException {
        page.filterButton.click();
        Select select1 = new Select(page.jobTitleFilter);
        Thread.sleep(3000);
        select1.selectByValue("1");
        page.getFilterButtonClick.click();
        Thread.sleep(2000);
        page.EmployeeOrderButton.click();
        TreeSet<String> treeSet = new TreeSet<>();
        Thread.sleep(2000);
        for (WebElement a : page.employeeList) {

            treeSet.add(a.getText());
        }
        int count = 0;
        for (String b : treeSet) {

            softAssert.assertEquals(b, page.employeeList.get(count).getText());
            count++;
        }
        BrowserUtils.takeScreenshot(driver);


    }

    @Test(dependsOnMethods = "filter")
    public void editName() throws InterruptedException {

        page.firstNameOrder.click();
        for (int i = 0; i < page.david.size(); i++) {
            if (page.david.get(i).getText().equals("David")) {
                page.edit.get(i).click();
                Thread.sleep(200);
                page.firstNameChange.clear();
                page.firstNameChange.sendKeys("Marcus");
                page.saveButtonFinal.click();
                break;

            }

        }


    }




    public static void select(WebElement element, String a) {
        Select select = new Select(element);
        select.selectByVisibleText(a);

    }

}
