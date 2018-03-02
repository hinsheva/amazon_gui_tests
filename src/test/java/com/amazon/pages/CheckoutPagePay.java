package com.amazon.pages;

import org.openqa.selenium.*;

import static com.amazon.Base.*;

public class CheckoutPagePay {
    private WebDriver driver;

    CheckoutPagePay(WebDriver driver) {
        this.driver = driver;
    }

    private By nameOnCardInputLocator = By.id("ccName");
    private By cardNumberInputLocator = By.id("addCreditCardNumber");
    private By expirationMonthDropDownLocator = By.xpath("//select[@id='ccMonth']");
    private By expirationYearDropDownLocator = By.xpath("//select[@id='ccYear']");
    private By addYourCardButtonLocator = By.id("ccAddCard");
    private By continueButtonLocator = By.id("continue-bottom");
    private By preSavedPaymentMethodRadioButtonLocator = By.id("pm_0");

    //Select Payment Method(use pre-saved card or save new one) and proceed to Confirmation Page
    public CheckoutPageConfirm selectPaymentMethod(String name, String cardNumber, String expirationMonth, String expirationYear) {
        try {
            getElement(preSavedPaymentMethodRadioButtonLocator);
        } catch (TimeoutException e) {
            saveNewCreditCard(name, cardNumber, expirationMonth, expirationYear);
            clickContinueButton();
            return new CheckoutPageConfirm(driver);
        }
        clickContinueButton();
        return new CheckoutPageConfirm(driver);
    }

    //Fill all required fields and save new credit card
    private void saveNewCreditCard(String name, String cardNumber, String month, String year){
        inputData(nameOnCardInputLocator, name);
        inputData(cardNumberInputLocator, cardNumber);

        //Select 'card Expiration Month' from the drop-down
        setJsDropDownOption(expirationMonthDropDownLocator, month);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", monthDropdown);
//        monthDropdown.sendKeys(month);

        //Select 'card Expiration Year' from the drop-down
        setJsDropDownOption(expirationYearDropDownLocator, year);
//        WebElement yearDropdown = driver.findElement(expirationYearDropDownLocator);
//        JavascriptExecutor jsex = (JavascriptExecutor) driver;
//        jsex.executeScript("arguments[0].setAttribute('style', 'display: block;')", yearDropdown);
//        yearDropdown.sendKeys(year);

        clickElement(addYourCardButtonLocator);
    }

    //Press the button to finish payment process
    private void clickContinueButton() {
        clickElement(continueButtonLocator);
    }
}
