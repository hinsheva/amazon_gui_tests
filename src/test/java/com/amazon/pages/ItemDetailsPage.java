package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage {
    private WebDriver driver;

    ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToBasketLocator = By.id("add-to-cart-button-ubb");

    //Press button to add the item to the Basket/Cart and navigate to Basket Page
    public CartPage addItemToCart() {
        driver.findElement(addToBasketLocator).click();
        return new CartPage(driver);
    }
}
