package com.amazon.pages;

import org.openqa.selenium.*;
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
    private By preSavedPaymentMethodRadioButtonLocator = By.id("pm_0");

    //Select Payment Method(use pre-saved card or save new one) and proceed to Confirmation Page
    public CheckoutPageConfirm selectPaymentMethod(String name, String cardNumber, String expirationMonth, String expirationYear) {
        try {
            driver.findElement(preSavedPaymentMethodRadioButtonLocator).isEnabled();
        } catch (NoSuchElementException e) {
            saveNewCreditCard(name, cardNumber, expirationMonth, expirationYear);
            clickContinueButton();
            return new CheckoutPageConfirm(driver);
        }
        clickContinueButton();
        return new CheckoutPageConfirm(driver);
    }

    //Fill all required fields and save new credit card
    private void saveNewCreditCard(String name, String cardNumber, String month, String year){
        driver.findElement(nameOnCardInputLocator).sendKeys(name);

        driver.findElement(cardNumberInputLocator).sendKeys(cardNumber);

        //Select 'card Expiration Month' from the drop-down
        WebElement monthDropdown = driver.findElement(expirationMonthDropDown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", monthDropdown);
        monthDropdown.sendKeys(month);

        //Select 'card Expiration Year' from the drop-down
        WebElement yearDropdown = driver.findElement(expirationYearDropDown);
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].setAttribute('style', 'display: block;')", yearDropdown);
        yearDropdown.sendKeys(year);

        driver.findElement(addYourCardButtonLocator).click();
    }

    //Press the button to finish payment process
    private void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickContinueButtonLocator));
        button.click();
    }
}
