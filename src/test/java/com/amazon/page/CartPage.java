package com.amazon.page;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By proceedToCheckoutButtonLocator = By.id("hlb-ptc-btn");
    private By cartItemNameLocator = By.id("mdp-title");
    private By successfulTitleForCartAddedItemLocator = By.id("huc-v2-order-row-confirm-text");
    private By itemDetailsArrowButtonLocator = By.id("huc-v2-order-row-item-B01MXF1PXY");

    //Press button to proceed to Checkout Page
    public CheckoutPageDelivery proceedToCheckout() {
        clickElement(proceedToCheckoutButtonLocator);
        return new CheckoutPageDelivery();
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