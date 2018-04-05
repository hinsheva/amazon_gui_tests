package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutDeliveryOptionsPage extends BasePage {

    public CheckoutDeliveryOptionsPage(WebDriver driver) {
        super(driver);
    }

    private By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private By deliveryOptionsPageTitleLocator = By.xpath("//h1[@class='a-spacing-base']");

    //Press the button to select Delivery Option and proceed to Payment Page
    public CheckoutPaymentPage submitDeliveryOption() {
        clickElement(continueButtonLocator);
        return new CheckoutPaymentPage(driver);
    }

    public String getTitle() {
        return getElementText(deliveryOptionsPageTitleLocator);
    }
}