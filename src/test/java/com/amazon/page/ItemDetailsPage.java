package com.amazon.page;

import org.openqa.selenium.By;

public class ItemDetailsPage extends BasePage {

    private By addToBasketButtonLocator = By.id("add-to-cart-button-ubb");

    //Press button to add the item to the Basket/Cart and navigate to Basket Page
    public CartPage addItemToCart() {
        clickElement(addToBasketButtonLocator);
        return new CartPage();
    }
}