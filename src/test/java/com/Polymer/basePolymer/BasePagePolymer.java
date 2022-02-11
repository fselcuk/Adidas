package com.Polymer.basePolymer;

import com.adidas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePagePolymer {


    public BasePagePolymer(){//constructor
        PageFactory.initElements(Driver.get(),this);

    }

    //public WebDriver driver=Driver.get();
    public WebDriverWait wait;
    @FindBy(partialLinkText = "Home")
    public WebElement home;

    @FindBy(linkText = "Cart")
    public WebElement cart;


}
