package com.amazon.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.Base.*;

public class CheckoutPageConfirm {
    private WebDriver driver;

    CheckoutPageConfirm(WebDriver driver) {
        this.driver = driver;
    }

    private By buyNowButtonLocator = By.xpath("//input[@value='Buy now']");
    private By loadingImageLocator = By.xpath("//img[@class='loading-spinner-spp-img']");
    private By yourOrderHasBeenPlacedTitleLocator = By.xpath("//h2[@class='a-color-success']");

    //Press the button to confirm Payment and proceed to Order Confirmation Info
    public void submitPayment() {
        waitUntilElementDisappears(loadingImageLocator);
        clickElement(buyNowButtonLocator);
    }

    public String getTitle() {
        return getElementText(yourOrderHasBeenPlacedTitleLocator);
    }
}
