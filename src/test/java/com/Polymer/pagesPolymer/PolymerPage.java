package com.Polymer.pagesPolymer;

import com.Polymer.basePolymer.BasePagePolymer;
import com.adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolymerPage extends BasePagePolymer {

    @FindBy(xpath = "//header/input[@id='new-todo']")
    public WebElement inputBox;

//    @FindBy(xpath = "(//div/label)[2]")
//    public WebElement secondFilledBox;

    public WebElement secondInput(){
        return Driver.get().findElement(By.xpath("(//div/label)[2]"));
    }

    @FindBy(xpath = "//input[@id='edit']")
    public WebElement edit;



}



