package com.adidas.pages;

import com.adidas.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceText;

    @FindBy(linkText ="Add to cart" )
    public WebElement addToCart;

    private int productAdder(String category, String product){
        // click on any category  Laptops, Phones, Monitors

        driver.findElement(By.linkText(category)).click();
        // click on any product that I provide
        driver.findElement(By.linkText(product)).click();

        String[] arrayAmount = priceText.getText().split(" ");
        int listPrice= Integer.parseInt(arrayAmount[0].substring(1));

        addToCart.click();

        // sometimes webpage gives no such ALert exception so we are waiting dynamically
       // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        home.click();

        return listPrice;
    }



}
