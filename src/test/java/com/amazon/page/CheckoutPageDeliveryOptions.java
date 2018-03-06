package com.amazon.page;

import org.openqa.selenium.By;

public class CheckoutPageDeliveryOptions extends BasePage {

    private By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private By deliveryOptionsPageTitle = By.xpath("//h1[@class='a-spacing-base']");

    //Press the button to select Delivery Option and proceed to Payment Page
    public CheckoutPagePay submitDeliveryOption() {
        clickElement(continueButtonLocator);
        return new CheckoutPagePay();
    }

    public String getTitle() {
        return getElementText(deliveryOptionsPageTitle);
    }
}