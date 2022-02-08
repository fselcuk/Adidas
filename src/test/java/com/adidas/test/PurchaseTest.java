package com.adidas.test;

import com.adidas.base.BasePage;
import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

       String [][] purchaseList=new String[][]{{"Laptops","Sony vaio i5"},{"Laptops","Dell i7 8gb"},{"Monitors","Apple monitor 24"},{"Phones","Nexus 6"}};

        for (String [] oneItem :purchaseList ) {
            expectedAmount+= productsPage.productAdder(oneItem[0],oneItem[1]);
            }

        String[] dropList=new String[]{"Dell i7 8gb","Apple monitor 24"};

        for (String dropItem : dropList) {
            expectedAmount-=cartPage.productRemover(dropItem);
        }
        Assert.assertEquals(Integer.parseInt(cartPage.actualAmount.getText()),expectedAmount, "PRICE LIST IS WRONG");
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("cartPage.actualAmount.getText() = " + cartPage.actualAmount.getText());
        }
     
        }






