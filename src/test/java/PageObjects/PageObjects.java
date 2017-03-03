package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by amey.rajapure on 2/25/2017.
 */
public class PageObjects {

    public static WebElement element;
    public static String sXpath;

    public String lnk_Gmail(){
        sXpath = "(.//*[@class='gb_Q gb_R'])";
        return sXpath;
    }

    public WebElement txt_EmailId(WebDriver driver){
        element = driver.findElement(By.id("Email"));
        return element;
    }

    public WebElement btn_Next(WebDriver driver){
        element = driver.findElement(By.id("next"));
        return element;
    }

    public WebElement txt_Password(WebDriver driver){
        element = driver.findElement(By.id("Passwd"));
        return element;
    }

    public WebElement btn_SignIn(WebDriver driver){
        element = driver.findElement(By.id("signIn"));
        return element;
    }
}
