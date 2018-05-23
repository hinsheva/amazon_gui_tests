package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By proceedToCheckoutButtonLocator = By.id("hlb-ptc-btn");
    private By cartItemNameLocator = By.id("mdp-title");
    private By successfulTitleForCartAddedItemLocator = By.id("huc-v2-order-row-confirm-text");
    private By itemDetailsArrowButtonLocator = By.id("huc-v2-order-row-item-0143126482");

    //Press button to proceed to Checkout Page
    public CheckoutDeliveryPage proceedToCheckout() {
        clickElement(proceedToCheckoutButtonLocator);
        return new CheckoutDeliveryPage(driver);
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
