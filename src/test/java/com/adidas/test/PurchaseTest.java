package com.adidas.test;

import com.adidas.base.BasePage;
import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.ProductsPage;
import org.testng.annotations.Test;

public class PurchaseTest extends TestBase {

    BasePage productsPage=new ProductsPage(); //polimorphic bir sekilde
    //base page e ulastik. extends olmadigi icin dogrudan ulasamadik o yuzden
    // object create ettik.
    BasePage cartPage=new CartPage();

    @Test
    public void Test1(){
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        productsPage.cart.click();

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }


}
