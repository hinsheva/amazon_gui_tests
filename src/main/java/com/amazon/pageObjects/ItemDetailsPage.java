package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends BasePage {

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    private By addToBasketButtonLocator = By.id("add-to-cart-button-ubb");

    //Press button to add the item to the Basket/Cart and navigate to Basket Page
    public CartPage addItemToCart() {
        clickElement(addToBasketButtonLocator);
        return new CartPage(driver);
    }
}