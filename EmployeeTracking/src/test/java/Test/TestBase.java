package Test;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.concurrent.TimeUnit;
public class TestBase {
    public static WebDriver driver;
    public static SoftAssert sa;

    @Parameters("DriverName")
    @BeforeTest(alwaysRun = true)
    public static void setUpDriver(String DriverName) {
        driver = Driver.getDriver(DriverName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sa = new SoftAssert();

    }

    public static String getRandomString() {
        String randomSTR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * randomSTR.length());
            salt.append(randomSTR.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static void select(WebElement element, String a) {
        Select select = new Select(element);
        select.selectByVisibleText(a);
    }
}