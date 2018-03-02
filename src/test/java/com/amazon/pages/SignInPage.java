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
        driver.findElement(emailInputLocator).sendKeys(email);
        try {
            driver.findElement(continueButtonLocator).isEnabled();
        } catch (NoSuchElementException e) {
            driver.findElement(passwordInputLocator).sendKeys(password);

            driver.findElement(signInButtonLocator).click();
            return new HomePage(driver);
        }
        driver.findElement(continueButtonLocator).click();

        driver.findElement(passwordInputLocator).sendKeys(password);

        driver.findElement(signInButtonLocator).click();
        return new HomePage(driver);
    }

    //Press the button to navigate to account creation page
    public CreateAccountPage clickCreateYourAmazonAccountButton() {
        driver.findElement(createYourAmazonAccountButtonLocator).click();
        return new CreateAccountPage(driver);
    }
}
