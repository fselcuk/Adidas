package com.Polymer.testsPolymer;

import com.Polymer.basePolymer.BasePagePolymer;
import com.Polymer.basePolymer.TestBasePolymer;
import com.Polymer.pagesPolymer.JavaScriptPage;
import com.Polymer.pagesPolymer.PolymerPage;
import com.adidas.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PolymerTest extends TestBasePolymer {

    /*
    TASK:
Write a basic browser automation framework to validate a Polymer website.
The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
The first step should be to load the website,
click within the JavaScript tab, and select the Polymer link.
The second step should be: Add two Todo items
Bonus: (optional stretch goal): Edit the content of the second Todo item
     */

   // BasePagePolymer basePagePolymer= new BasePagePolymer(); yapamayiz cunku BasePagePolymer abstract bir class

    JavaScriptPage javaScriptPage=new JavaScriptPage();
    @Test
    public void test(){
        extentLogger=report.createTest("Poylmer Test started");
        //we connect to our Polymer Website,,,

    //JavaScript click
        extentLogger.info("clicking on JavaScript tab");
    javaScriptPage.getElementTab("JavaScript").click();
    // Polymer click
        extentLogger.info("clicking on Polymer option");
    javaScriptPage.getExamples("Polymer").click();
    // sending keys to todo box
        extentLogger.info("checking that whether we are at the expected page");
        Assert.assertTrue(Driver.get().getTitle().contains("Polymer"));

        PolymerPage polymerpage=new PolymerPage();
        extentLogger.info("Sending keys to todo box and hit enter");
        polymerpage.inputBox.sendKeys("fehmi"+Keys.ENTER);
        //polymerpage.inputBox.sendKeys(Keys.ENTER);

        extentLogger.info("Sending keys to second todo box and hit enter");
       String todo2="selcuk";
        polymerpage.inputBox.sendKeys(todo2+Keys.ENTER);
       // polymerpage.inputBox.sendKeys(Keys.ENTER);

        extentLogger.info("second input is displayed or not");
        Assert.assertTrue(polymerpage.secondInput().isDisplayed());

        extentLogger.info("edit the second input so double click is needed");
        Actions actions=new Actions(Driver.get());
        actions.doubleClick(polymerpage.secondInput()).perform();

        //delete the box you want to edit
        for (int i = 0; i < todo2.length(); i++) {
            polymerpage.edit.sendKeys(Keys.BACK_SPACE);
        }
        polymerpage.edit.sendKeys("edited version of Selcuk"+Keys.ENTER);

        Assert.assertTrue(polymerpage.secondInput().isDisplayed());




    }
}
