package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage extends BasePage {

    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    private By yourOrderHasBeenPlacedTitleLocator = By.xpath("//h2[@class='a-color-success']");
    private By orderNumberTitleLocator = By.xpath("//h5[contains(text(),'Order Number:')]");

    public String getPlacedOrderTitle() {
        return getElementText(yourOrderHasBeenPlacedTitleLocator);
    }

    public String getOrderInfo() {
        return getElementText(orderNumberTitleLocator).split(":")[0];
    }
}
