package com.amazon.page;

import org.openqa.selenium.By;

public class CheckoutPageConfirm extends BasePage {

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