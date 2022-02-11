package com.Polymer.pagesPolymer;

import com.Polymer.basePolymer.BasePagePolymer;
import com.adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptPage extends BasePagePolymer {


    public WebElement getExamples(String element) {

        return Driver.get().findElement(By.xpath("//li/a[ .='" + element + "']"));
    }

}