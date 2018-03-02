package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.Base.clickElement;
import static com.amazon.Base.getElementText;

public class CheckoutPageDeliveryOptions {
    private WebDriver driver;

    CheckoutPageDeliveryOptions(WebDriver driver) {
        this.driver = driver;
    }

    private By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private By deliveryOptionsPageTitle = By.xpath("//h1[@class='a-spacing-base']");

    //Press the button to select Delivery Option and proceed to Payment Page
    public CheckoutPagePay submitDeliveryOption() {
        clickElement(continueButtonLocator);
        return new CheckoutPagePay(driver);
    }

    public String getTitle(){
        return getElementText(deliveryOptionsPageTitle);
    }
}
