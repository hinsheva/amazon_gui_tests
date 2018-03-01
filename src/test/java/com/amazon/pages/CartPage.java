package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By proceedToCheckoutButtonLocator = By.id("hlb-ptc-btn");
    private By cartItemNameLocator = By.id("mdp-title");
    private By successfulTitleForCartAddedItem = By.id("huc-v2-order-row-confirm-text");
    private By itemDetailsArrowButton = By.id("huc-v2-order-row-item-B01MXF1PXY");

    //Press button to proceed to Checkout Page
    public CheckoutPageDelivery proceedToCheckout() {
        driver.findElement(proceedToCheckoutButtonLocator).click();
        return new CheckoutPageDelivery(driver);
    }

    //Press the button to see Item Details Info
    public void getItemDetails() {
        driver.findElement(itemDetailsArrowButton).click();
    }

    public String getAddedToCartItemTitle() {
        return driver.findElement(successfulTitleForCartAddedItem).getText();
    }

    public String getItemName() {
        return driver.findElement(cartItemNameLocator).getText();
    }
}
