package Utils;

import Test.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
public class BrowserUtils extends TestBase {

    public static void switchWindow(WebDriver driver, String targetTitle){
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        if(!driver.getTitle().equals(targetTitle)){
            for(String window:allWindows){
                driver.switchTo().window(window);
                if(driver.getTitle().equals(targetTitle)){
                    break;
                }
            }

        }



    }
    public static void verifyBrokenLink( List<WebElement> tags)  {
        for(WebElement links: tags){
            String hrefValue=links.getAttribute("href") ;
            try{URL url=new URL(hrefValue);
                HttpURLConnection connect=(HttpURLConnection) url.openConnection();
                connect.setConnectTimeout(3000);
                connect.connect();
                if(connect.getResponseCode()>=400|| connect.getResponseCode()>=500){
                    System.out.println(hrefValue);
                    System.out.println("The link is broken   \n"+connect.getResponseMessage()+"   \n"+
                            connect.getResponseCode());

                }
            }catch (IOException a){
                System.out.println(a.getStackTrace());
            }

        }

    }


    public void hoverOver(WebDriver driver, WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();

    }

    public static void dragAndDrop(WebDriver driver,WebElement from, WebElement to){
        Actions actions=new Actions(driver);
        actions.dragAndDrop(from,to).build().perform();



    }
    public  static void waitUntilVisibilityOfElement(WebDriver driver, WebElement element, int timeUnits){
        Wait wait=new WebDriverWait(driver,timeUnits);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public static void clickabilityOfElement(WebDriver driver, WebElement element, int timeUnits){
        Wait wait=new WebDriverWait(driver, timeUnits);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public static void takeScreenshot(WebDriver driver) throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File desFile=new File("ScreenShot/"+System.currentTimeMillis()+".png");
        FileUtils.copyFile(src,desFile);

    }
    public static void scrollDown(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,3000)");
    }








}
