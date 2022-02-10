package com.adidas.base;

import com.adidas.utilities.BrowserUtils;
import com.adidas.utilities.ConfigurationReader;
import com.adidas.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class TestBase  {
    //common reusable variables that we use throughout our test cases
    //and also before and aftr methodslar da testbase de olur
    protected WebDriver driver;
    protected Actions actions;
    public WebDriverWait wait;
    protected String url;
    //niye protected, cunku diger class'lardan hangisi bu testbase classi inherit
    // yaparsa onlar kullanabilsin, yoksa bunlara erilemez
    //access modifiers

    //this class is used for starting and building reports
    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Adidas Purchase Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @BeforeMethod
    public void setUp(){
        url= ConfigurationReader.get("url");

        driver= Driver.get(); //this is enough to initialize the driver object
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//IMPLICIT WAITING
        wait=new WebDriverWait(driver, 5);//EXPLICIT WAITING

        driver.get(url);// baglanacagimiz webpage e burdan gidiyoruz
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }
    @AfterTest
    public void tearDownTest(){
        //this is when the report is actually created
        report.flush();

    }
}
