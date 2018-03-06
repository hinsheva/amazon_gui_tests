package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class CheckoutPagePay extends BasePage {

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
            return new CheckoutPageConfirm();
        }
        clickContinueButton();
        return new CheckoutPageConfirm();
    }

    //Fill all required fields and save new credit card
    private void saveNewCreditCard(String name, String cardNumber, String month, String year) {
        inputData(nameOnCardInputLocator, name);
        inputData(cardNumberInputLocator, cardNumber);
        setJsDropDownOption(expirationMonthDropDownLocator, month);
        setJsDropDownOption(expirationYearDropDownLocator, year);
        clickElement(addYourCardButtonLocator);
    }

    //Press the button to finish payment process
    private void clickContinueButton() {
        clickElement(continueButtonLocator);
    }
}