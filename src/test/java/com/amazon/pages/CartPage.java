package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.Base.clickElement;
import static com.amazon.Base.getElementText;

public class CartPage {
    private WebDriver driver;

    CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By proceedToCheckoutButtonLocator = By.id("hlb-ptc-btn");
    private By cartItemNameLocator = By.id("mdp-title");
    private By successfulTitleForCartAddedItemLocator = By.id("huc-v2-order-row-confirm-text");
    private By itemDetailsArrowButtonLocator = By.id("huc-v2-order-row-item-B01MXF1PXY");

    //Press button to proceed to Checkout Page
    public CheckoutPageDelivery proceedToCheckout() {
        clickElement(proceedToCheckoutButtonLocator);
        return new CheckoutPageDelivery(driver);
    }

    //Press the button to see Item Details Info
    public void getItemDetails() {
        clickElement(itemDetailsArrowButtonLocator);
    }

    public String getAddedToCartItemTitle() {
        return getElementText(successfulTitleForCartAddedItemLocator);
    }

    public String getItemName() {
        return getElementText(cartItemNameLocator);
    }
}
