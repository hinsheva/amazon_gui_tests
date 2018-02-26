package com.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By proceedToCheckoutButtonLocator = By.xpath("//*[@id=\"hlb-ptc-btn\"]");
    private By cartItemNameLocator = By.xpath("//span[contains(text(),'Silver Bay: A Novel by Jojo Moyes (2014-08-26)')]");
    private By successfulTitleForCartAddedItem = By.xpath("//h1[contains(text(),'Added to Basket')]");
    private By itemDetailsArrowButton = By.xpath("//i[@class='a-icon a-icon-popover huc-v2-order-row-down-arrow']");

    public CheckoutPageDelivery checkItemAndProceedToCheckout(String itemName, String successfulTitle){
        checkCartItem(itemName);
        checkSuccessfulTitleForCartAddedItem(successfulTitle);
        driver.findElement(proceedToCheckoutButtonLocator).click();
        return new CheckoutPageDelivery(driver);
    }

    private void checkCartItem(String itemName){
        checkItemDetails();
        Assert.assertEquals(itemName, driver.findElement(cartItemNameLocator).getText());
    }

    private void checkItemDetails(){
        driver.findElement(itemDetailsArrowButton).click();
    }

    private void checkSuccessfulTitleForCartAddedItem(String successfulTitle){
        Assert.assertEquals(successfulTitle, driver.findElement(successfulTitleForCartAddedItem).getText());
    }
}
