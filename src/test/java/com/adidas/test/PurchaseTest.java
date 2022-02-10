package com.adidas.test;

import com.adidas.base.BasePage;
import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.ProductsPage;
import com.adidas.utilities.BrowserUtils;
import com.adidas.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseTest extends TestBase {

    ProductsPage productsPage=new ProductsPage();
    CartPage cartPage=new CartPage();

    int expectedAmount=0;

    @Test
    public void Test1(){

       extentLogger=report.createTest("adding anf removing product test/adidas");

       extentLogger.info("adding items to cart");
       String [][] purchaseList=new String[][]{{"Laptops","Sony vaio i5"},{"Laptops","Dell i7 8gb"},{"Monitors","Apple monitor 24"},{"Phones","Nexus 6"}};

        for (String [] oneItem :purchaseList ) {
            expectedAmount+= productsPage.productAdder(oneItem[0],oneItem[1]);
            }

        extentLogger.info("removing the unwanted items from cart");
        String[] dropList=new String[]{"Dell i7 8gb","Apple monitor 24"};

        for (String dropItem : dropList) {
            expectedAmount-=cartPage.productRemover(dropItem,wait);
        }
        Assert.assertEquals(Integer.parseInt(cartPage.actualAmount.getText()),expectedAmount, "PRICE LIST IS WRONG");
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("cartPage.actualAmount.getText() = " + cartPage.actualAmount.getText());


        //after ready your items in the cart we need to click Place Order button to fill customer info
        wait = new WebDriverWait(Driver.get(),5);
        BrowserUtils.waitFor(3);

        extentLogger.info("click on Place Order button");
        cartPage.placeOrder.click();

        extentLogger.info("fill out the form using faker class");
        cartPage.fillForm();

        extentLogger.info("click on purchase button");
        cartPage.Purchase.click();

        extentLogger.info("verifying the confirmation info is displayed");
        Assert.assertTrue(cartPage.confirmation.isDisplayed());

        extentLogger.info("verifying that expecting and actual amounts are equal");
        Assert.assertEquals(Integer.parseInt(cartPage.actualAmount.getText()),expectedAmount);
        cartPage.OK.click();


    }



}






