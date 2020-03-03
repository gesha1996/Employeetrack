package Test;

import Page.*;
import Utils.BrowserUtils;
import Utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sun.jvm.hotspot.debugger.Page;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyWithDetails extends TestBase {
    PageSwitch pageSwitch;
 Payrollpage payrollPage;
    ValidationPage page;
    SoftAssert softAssert;
    PageClass pagePrevious;
    PageFinance pageFinance;
    @DataProvider(name = "salaryInfo")
    public Object[][] salary() {

        return new Object[][]{
                {"Fixed Allowance", "200000", "Test1"},
                {"Car Allowance", "10000000", "Test2"},
                {"Telephone Allowance", "100", "Test3"},
                {"Regular Hourly Pay", "70", "Test4"},
                {"Overtime Hourly Pay", "80", "Test5"}};
    }
    @BeforeClass
    public void setup() {
        pageSwitch=new PageSwitch(driver);
        payrollPage=new Payrollpage(driver);
        pageFinance = new PageFinance(driver);
        page = new ValidationPage(driver);
        pagePrevious = new PageClass(driver);
        softAssert = new SoftAssert();
        driver.get("http://icehrm-open.gamonoid.com/login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pagePrevious.username.sendKeys("admin");
        pagePrevious.password.sendKeys("admin" + Keys.ENTER);

    }
    @Test(priority = 0,enabled = false)
    public void switchTest() throws InterruptedException {
        Thread.sleep(2000);
        pageSwitch.switchBtnOnMainPage.click();
        String expectedHeader1 = "Switch Employee";
        String expectedHeader2 = "Select The Employee to Switch Into";
        softAssert.assertEquals(pageSwitch.switchEmployeeText.getText(), expectedHeader1);
        softAssert.assertEquals(pageSwitch.selectTheEmployeeText.getText(), expectedHeader2);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageSwitch.arrow.click();
        select(pageSwitch.saraHelen, "Taylor Holmes");
        pageSwitch.switchBtn.click();
        String expectedName="Taylor Holmes";
        String expectedText=" Changed To ";
        softAssert.assertEquals(pageSwitch.saraHelenDisplayed.getText(),expectedName);
     //   softAssert.assertEquals(pageSwitch.changedToText.getText(), expectedText);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

    }

    @Test(dataProvider = "salaryInfo",priority = 1)
    public void financeTest(String salary1, String amount, String details) throws InterruptedException, IOException {
        pageFinance.financeBtn.click();
        pageFinance.salaryBtn.click();
        softAssert.assertEquals(pageFinance.text.getText(), "Salary Finance");
        Thread.sleep(2000);
        pageFinance.addNewBtn.click();
        Thread.sleep(2000);
        select(pageFinance.SalaryComponent, salary1);
        pageFinance.Amount.sendKeys(amount);
        pageFinance.details.sendKeys(details);
        pageFinance.save.click();
        for (WebElement str : pageFinance.listOfDetails) {
            softAssert.assertEquals(details, str.getText());
        }
        BrowserUtils.takeScreenshot(driver);

    }

    @Test(priority = 2)
    public void validationOfDetailsWithSalary() throws InterruptedException {
        Thread.sleep(3000);
        page.searchBox.sendKeys("car allowance");
        List<String> expected = new ArrayList<>();
        expected.add("10000000.00");
        expected.add("Test2");

        Assert.assertTrue(page.carAllowanceList().containsAll(expected));

    }

    @Test(priority = 3)
    public void validationDetailsWithAmount() {
        page.searchBox.clear();
        page.searchBox.sendKeys("70.00");
        List<String> expected = new ArrayList<>();
        expected.add("Regular Hourly Pay");
        expected.add("Test4");
        Assert.assertTrue(page.amountList().containsAll(expected));
    }

    @Test(priority = 4)
    public void validationDetailsWithTest() {
        page.searchBox.clear();
        page.searchBox.sendKeys("Test5");
        List<String> expected = new ArrayList<>();
        expected.add("Overtime Hourly Pay");
        expected.add("80.00");
        Assert.assertTrue(page.testList().containsAll(expected));
    }
    @Test(priority = 5)
    public void payrollTest() throws InterruptedException, IOException {
        payrollPage.payrollBtn.click();
        payrollPage.salaryBtn.click();
        payrollPage.employeeComponents.click();
        payrollPage.filterBtn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        payrollPage.arrow.click();
        Thread.sleep(3000);
        select(payrollPage.taylorHolmes,"Taylor Holmes");
        payrollPage.filter.click();
        for(WebElement a:payrollPage.finalList){
            softAssert.assertTrue(a.isDisplayed());
        }
        BrowserUtils.takeScreenshot(driver);


    }

}
