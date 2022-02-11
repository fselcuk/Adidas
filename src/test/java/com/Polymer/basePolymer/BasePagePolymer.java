package com.Polymer.basePolymer;

import com.adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePagePolymer {


    public BasePagePolymer(){//constructor
        PageFactory.initElements(Driver.get(),this);

    }

    // //div[.='Compile-to-JS']

    public WebElement getElementTab(String tab){

        return Driver.get().findElement(By.xpath("//div[.='"+tab+"']"));
    }


}
