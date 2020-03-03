package Page;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageSwitch {
    public PageSwitch(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath ="//span[.='Switch']")
    public WebElement switchBtnOnMainPage;
    @FindBy(xpath = "//span[@id='select2-chosen-1']")
    public WebElement arrow;




    @FindBy(id = "switch_emp")
    public WebElement saraHelen;
    @FindBy(xpath = "//button[.='Switch']")
    public  WebElement switchBtn;
    @FindBy(xpath = "//h3[@id='myModalLabel']")
    public WebElement switchEmployeeText;
    @FindBy(xpath = "//p[contains(text(),'Select The Employee to Switch Into')]")
    public WebElement selectTheEmployeeText;
    @FindBy (xpath = "//a[.='Taylor Holmes']")
    public WebElement saraHelenDisplayed;
    @FindBy (xpath = "//i[@class='fa fa-circle text-warning']")
    public WebElement changedToText;



}
/*
*   */
