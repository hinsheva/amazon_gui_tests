package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPagePay {
    private WebDriver driver;

    CheckoutPagePay(WebDriver driver) {
        this.driver = driver;
    }

    private By nameOnCardInputLocator = By.id("ccName");
    private By cardNumberInputLocator = By.id("addCreditCardNumber");
    private By expirationMonthDropDown = By.xpath("//select[@id='ccMonth']");
    private By expirationYearDropDown = By.xpath("//select[@id='ccYear']");
    private By addYourCardButtonLocator = By.id("ccAddCard");
    private By clickContinueButtonLocator = By.id("continue-bottom");

    //Fill all required user's credit card info to submit Payment and proceed to Confirmation Page
    public CheckoutPageConfirm fillCreditCardInfo(String name, String cardNumber, String expirationMonth, String expirationYear) {
        typeName(name);
        typeCardNumber(cardNumber);
        selectExpirationMonth(expirationMonth);
        selectExpirationYear(expirationYear);
        clickAddYourCardButton();
        clickContinueButton();
        return new CheckoutPageConfirm(driver);
    }

    //Fill 'card name' field with user's name
    private void typeName(String name) {
        driver.findElement(nameOnCardInputLocator).sendKeys(name);
    }

    //Fill 'card number' field with user's card number
    private void typeCardNumber(String cardNumber) {
        driver.findElement(cardNumberInputLocator).sendKeys(cardNumber);
    }

    //Select 'card Expiration Month' from the drop-down
    private void selectExpirationMonth(String month) {
        WebElement dropdown = driver.findElement(expirationMonthDropDown);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", dropdown);
        dropdown.sendKeys(month);
    }

    //Select 'card Expiration Year' from the drop-down
    private void selectExpirationYear(String year) {
        WebElement dropdown = driver.findElement(expirationYearDropDown);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", dropdown);
        dropdown.sendKeys(year);
    }

    //Press the button to save the card info
    private void clickAddYourCardButton() {
        driver.findElement(addYourCardButtonLocator).click();
    }

    //Press the button to finish payment process
    private void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickContinueButtonLocator));
        button.click();
    }
}
