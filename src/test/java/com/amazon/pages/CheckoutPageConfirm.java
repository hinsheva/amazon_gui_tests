package com.amazon.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageConfirm {
    private WebDriver driver;

    CheckoutPageConfirm(WebDriver driver) {
        this.driver = driver;
    }

    private By clickBuyNowButtonLocator = By.xpath("//input[@value='Buy now']");
    private By loadingImageLocator = By.xpath("//img[@class='loading-spinner-spp-img']");
    private By yourOrderHasBeenPlacedLocator = By.xpath("//h2[@class='a-color-success']");

    //Press the button to confirm Payment and proceed to Order Confirmation Info
    public void submitPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = driver.findElement(clickBuyNowButtonLocator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImageLocator));
        button.click();
    }

    public String getTitle() {
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement successForm = driver.findElement(yourOrderHasBeenPlacedLocator);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(yourOrderHasBeenPlacedLocator));
//        return successForm.getText();
        return driver.findElement(yourOrderHasBeenPlacedLocator).getText();
    }
}
