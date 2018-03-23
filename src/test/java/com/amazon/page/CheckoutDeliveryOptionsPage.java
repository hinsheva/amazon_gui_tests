package com.amazon.page;

import org.openqa.selenium.By;

public class CheckoutDeliveryOptionsPage extends BasePage {

    private By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private By deliveryOptionsPageTitleLocator = By.xpath("//h1[@class='a-spacing-base']");

    //Press the button to select Delivery Option and proceed to Payment Page
    public CheckoutPaymentPage submitDeliveryOption() {
        clickElement(continueButtonLocator);
        return new CheckoutPaymentPage();
    }

    public String getTitle() {
        return getElementText(deliveryOptionsPageTitleLocator);
    }
}