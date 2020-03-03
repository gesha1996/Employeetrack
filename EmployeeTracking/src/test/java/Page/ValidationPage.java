package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidationPage {
    public ValidationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
   @FindBy(xpath = "((//td[.='Car Allowance'])[1]/..//td)")
    public List<WebElement> carAllowance;
    @FindBy(xpath = "(//td[.='Regular Hourly Pay'])[1]/..//td")
    public List<WebElement> amount;
    @FindBy(xpath = "(//td[.='Test5'])[1]/..//td")
    public List<WebElement>test;
    @FindBy(xpath = "//label//input")
    public WebElement searchBox;
    public  List<String> carAllowanceList() {
        List<String> actual = new ArrayList<>();
        for (WebElement str : carAllowance) {
            actual.add(str.getText());
        }
        return actual;

    }
    public List<String> amountList(){
        List<String> actual = new ArrayList<>();
        for (WebElement str : amount) {
            actual.add(str.getText());
        }
        return actual;
    }
    public List<String> testList(){
        List<String> actual = new ArrayList<>();
        for (WebElement str : test) {
            actual.add(str.getText());
        }
        return actual;
    }
}