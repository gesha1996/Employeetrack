package Test;

import Page.PageClass;
import Page.PageFinance;
import Page.PageSwitch;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SwitchTest extends TestBase {

    PageSwitch page;
    SoftAssert softAssert;
    PageClass pagePrevious;


    @BeforeClass
    public void setup() {
        pagePrevious = new PageClass(driver);

        page = new PageSwitch(driver);
        softAssert = new SoftAssert();
        driver.get("http://icehrm-open.gamonoid.com/login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pagePrevious.username.sendKeys("admin");
        pagePrevious.password.sendKeys("admin" + Keys.ENTER);

    }



    }






