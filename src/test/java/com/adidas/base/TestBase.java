package com.adidas.base;

import com.adidas.utilities.ConfigurationReader;
import com.adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

    @BeforeMethod
    public void setUp(){
        url= ConfigurationReader.get("url");

        driver= Driver.get(); //this is enough to initialize the driver object
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//IMPLICIT WAITING
        wait=new WebDriverWait(driver, 20);//EXPLICIT WAITING

        driver.get(url);// baglanacagimiz webpage e burdan gidiyoruz
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
