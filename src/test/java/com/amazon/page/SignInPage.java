package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By createYourAmazonAccountButtonLocator = By.id("createAccountSubmit");
    private By emailInputLocator = By.id("ap_email");
    private By passwordInputLocator = By.id("ap_password");
    private By continueButtonLocator = By.id("continue");
    private By signInButtonLocator = By.id("signInSubmit");

    //Login to User's Amazon Account. Note two different forms can appear.
    public HomePage logIn(String email, String password) {
        inputData(emailInputLocator, email);
        try {
            getElement(continueButtonLocator).isEnabled();
        } catch (NoSuchElementException e) {
            inputData(passwordInputLocator, password);
            clickElement(signInButtonLocator);
            return new HomePage(driver);
        }
        clickElement(continueButtonLocator);
        inputData(passwordInputLocator, password);
        clickElement(signInButtonLocator);
        return new HomePage(driver);
    }

    //Press the button to navigate to account creation page
    public CreateAccountPage clickCreateYourAmazonAccountButton() {
        clickElement(createYourAmazonAccountButtonLocator);
        return new CreateAccountPage(driver);
    }
}