package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createYourAmazonAccountButtonLocator = By.id("createAccountSubmit");
    private By emailInputLocator = By.id("ap_email");
    private By passwordInputLocator = By.id("ap_password");
    private By continueButtonLocator = By.id("continue");
    private By signInButtonLocator = By.id("signInSubmit");

    //Login to User's Amazon Account. Note two different forms can appear.
    public HomePage logIn(String email, String password) {
        typeEmail(email);
        try {
            driver.findElement(continueButtonLocator).isEnabled();
        } catch (NoSuchElementException e) {
            typePassword(password);
            clickSignInButton();
            return new HomePage(driver);
        }
        clickContinueButton();
        typePassword(password);
        clickSignInButton();
        return new HomePage(driver);
    }

    //Press the button to navigate to account creation page
    public CreateAccountPage clickCreateYourAmazonAccountButton() {
        driver.findElement(createYourAmazonAccountButtonLocator).click();
        return new CreateAccountPage(driver);
    }

    //Fill 'email' field with user's email info
    private void typeEmail(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    //Press the button to continue login process
    private void clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
    }

    //Fill 'password' field with user's password info
    private void typePassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    //Press the button to submit login
    private void clickSignInButton() {
        driver.findElement(signInButtonLocator).click();
    }
}
