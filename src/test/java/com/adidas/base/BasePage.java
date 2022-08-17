package com.adidas.base;

import com.adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage  {


    public BasePage(){//constructor
        PageFactory.initElements(Driver.get(),this);
        //POM Structure
//pagefactory class comes from selenium. we are initializing our page
    }

    public WebDriverWait wait;
    @FindBy(partialLinkText = "Home") //used instead of find element method
    public WebElement home;

    @FindBy(linkText = "Cart")
    public WebElement cart;


}
