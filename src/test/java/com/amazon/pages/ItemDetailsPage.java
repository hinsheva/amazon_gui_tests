package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.Base.clickElement;

public class ItemDetailsPage {
    private WebDriver driver;

    ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToBasketButtonLocator = By.id("add-to-cart-button-ubb");

    //Press button to add the item to the Basket/Cart and navigate to Basket Page
    public CartPage addItemToCart() {
        clickElement(addToBasketButtonLocator);
        return new CartPage(driver);
    }
}
