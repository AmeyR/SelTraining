package Tests;

import PageObjects.PageObjects;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Tests.getTestDataFromExcel;

/**
 * Created by amey.rajapure on 2/25/2017.
 */

//Checked out copy from SVN and adding a comment here.

public class TestNGCases {

    WebDriver driver = null;
    //PageObjects pgObj = new PageObjects();  //Not used cuurently

    public static ExtentReports extent;
    public static ExtentTest extest;
    private static long millis = System.currentTimeMillis();
    public static String reportLocation = "reports/detailTestReport_" + millis + ".html";

    @BeforeTest
    public void setUp(){
        //Firefox driver
        //System.setProperty("webdriver.firefox.marionette", "D:\\Projects\\Test Innovation\\IntelliJ IDE\\Libraries\\geckodriver.exe");
        //driver = new FirefoxDriver();

        //Chrome driver
        System.setProperty("webdriver.chrome.driver","D:\\Projects\\Test Innovation\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        //HtmlUnit (headless) driver
        //driver = new HtmlUnitDriver();

        driver.manage().window().maximize();

        //Extent Report
        extent = new ExtentReports(reportLocation,true);
        extent.startReporter(ReporterType.DB, (new File(reportLocation)).getParent() + File.separator);

        String sURL = "http://rav-vm-vdi-065/RMSTraining/";
        driver.navigate().to(sURL);
    }

    /*@AfterTest
    public void tearDown(){
        driver.quit();
    }*/

/*
    @Test(priority = 1)
    public void clickRaiseTrainingLink(){
        */
/*String sXpath = pgObj.lnk_Gmail();
        sXpath = sXpath+ "[1]";
        extest = extent.startTest("TC: Navigate to Gmail").assignCategory("Gmail");
        //driver.findElement(By.xpath(sXpath)).click();

        String sURL = driver.getCurrentUrl();
        extest.log(LogStatus.PASS,"Page URL is : " +sURL);
        extent.flush();
        extent.endTest(extest);*//*


        WebElement training = driver.findElement(By.xpath("./*/
/*[@id='divMenu']/ul/li[2]"));
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(training).build().perform();

        driver.findElement(By.xpath("//a[@href='http://rav-vm-vdi-065/RMSTraining/Training/RaiseTrainingRequest']")).click();

    }
*/

/*
    @Test(priority = 2, dependsOnMethods = "clickRaiseTrainingLink")
    public void raiseTrainingReq() throws InterruptedException {
        Select TrainingType = new Select(driver.findElement(By.xpath("/*/
/*[@id=\"TrainingType\"]")));
        TrainingType.selectByIndex(3);
        Thread.sleep(5000);

        Select Type = new Select(driver.findElement(By.id("Type")));
        Type.selectByIndex(1);

        driver.findElement(By.id("Agenda")).sendKeys("Learning Selenium");
        driver.findElement(By.id("Topic")).sendKeys("Selenium Basics");
        driver.findElement(By.xpath("/*/
/*[@id=\"check\"]/img")).click();

        driver.findElement(By.xpath("/*/
/*[@id=\"viewreport_filter\"]/label/input")).sendKeys("amey");


        int iRowCount = driver.findElements(By.xpath("/*/
/*[@id=\"viewreport\"]/tbody/tr")).size();
        int iColCount = driver.findElements(By.xpath("/*/
/*[@id=\"viewreport\"]/thead/tr[1]/th")).size();

        //System.out.println("iRowCount = " +iRowCount+ ", iColCount = " +iColCount);

        for(int rows=1; rows<=iRowCount; rows++){
            //System.out.println("**********Data for Row #" +rows+ " ****************");
            String sCellXpath = "*/
/*//*
*/
/*[@id=\"viewreport\"]/tbody/tr[" +rows+ "]/td[3]";
            String sCheckBoxPath = "*/
/*//*
*/
/*[@id=\"viewreport\"]/tbody/tr[" +rows+ "]/td[1]/input[1]";
            String sFullName = driver.findElement(By.xpath(sCellXpath)).getText();
            System.out.println("sFullName = " +sFullName);
            if(sFullName.equalsIgnoreCase("Amey Rajapure")){
                if(!driver.findElement(By.xpath(sCheckBoxPath)).isSelected()){
                    driver.findElement(By.xpath(sCheckBoxPath)).click();
                }
                driver.findElement(By.id("BtnSecondSelect")).click();


            }
            */
/*for(int cols=1; cols<=iColCount; cols++){
                String sCellXpath = "*/
/*//*
*/
/*[@id=\"viewreport\"]/tbody/tr[" +rows+ "]/td[" +cols+"]";
                String sCheckBoxPath = sCellXpath + "/input[1]";
                String sCellVal = driver.findElement(By.xpath(sCellXpath)).getText();
                if(cols==1){
                    System.out.println("Column #" +cols+ " isSelected before click: " +driver.findElement(By.xpath(sCheckBoxPath)).isSelected());
                    driver.findElement(By.xpath(sCheckBoxPath)).click();
                    System.out.println("Column #" +cols+ " isSelected after click: " +driver.findElement(By.xpath(sCheckBoxPath)).isSelected());
                }
                System.out.println("Column #" +cols+ " Value: " +sCellVal);
            }*//*

        }



    } */

    @Test
    public void TestExcelMethod() throws IOException {
        getTestDataFromExcel objTC = new getTestDataFromExcel();
        ArrayList<String> sArryLstTestData = new ArrayList<String>();

        sArryLstTestData = objTC.getTestData("Personal Details","TC_3");

        for(String data : sArryLstTestData){
            System.out.println(data);
        }

        System.out.println("-------------------------------------");
        sArryLstTestData = objTC.getTestData("Card Details","TC_3");

        for(String data : sArryLstTestData){
            System.out.println(data);
        }
    }
}
