package com.amazon.page;

import org.openqa.selenium.By;

public class CheckoutConfirmationPage extends BasePage {

    private By buyNowButtonLocator = By.xpath("//input[@value='Buy now']");
    private By loadingImageLocator = By.xpath("//img[@class='loading-spinner-spp-img']");

    //Press the button to confirm Payment and proceed to Order Confirmation Info
    public HomePage submitPayment() {
        waitUntilElementDisappears(loadingImageLocator);
        clickElement(buyNowButtonLocator);
        return new HomePage();
    }
}