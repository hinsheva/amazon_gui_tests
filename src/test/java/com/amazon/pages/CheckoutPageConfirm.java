package com.amazon.pages;


import org.junit.Assert;
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

    public HomePage checkSuccessfullyPlacedOrder(String successTitle) {
        Assert.assertEquals(successTitle, driver.findElement(yourOrderHasBeenPlacedLocator).getText());
        return new HomePage(driver);
    }

    public void submitPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = driver.findElement(clickBuyNowButtonLocator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImageLocator));
        button.click();
    }
}
    /*public void submitPayment() {
         driver.findElement(clickBuyNowButtonLocator).click();

         OR

        WebElement button = driver.findElement(clickBuyNowButtonLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();

        OR

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()", button);

        button.click();
    }*/
