package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutConfirmationPage extends BasePage {

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By buyNowButtonLocator = By.xpath("//input[@value='Buy now']");
    private By loadingImageLocator = By.xpath("//img[@class='loading-spinner-spp-img']");

    //Press the button to confirm Payment and proceed to Order Confirmation Info
    public ThankYouPage submitPayment() {
        waitUntilElementDisappears(loadingImageLocator);
        clickElement(buyNowButtonLocator);
        return new ThankYouPage(driver);
    }
}