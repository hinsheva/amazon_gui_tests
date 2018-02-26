package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageDeliveryOptions {
    private WebDriver driver;

    CheckoutPageDeliveryOptions(WebDriver driver){
        this.driver = driver;
    }

    private By continueButtonLocator = By.xpath("//input[@value='Continue']");

    public CheckoutPagePay submitDeliveryOption(){
        driver.findElement(continueButtonLocator).click();
        return new CheckoutPagePay(driver);
    }
}
