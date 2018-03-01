package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
    private WebDriver driver;

    CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInputLocator = By.id("ap_customer_name");
    private By emailInputLocator = By.id("ap_email");
    private By passwordInputLocator = By.id("ap_password");
    private By reEnterPasswordInputLocator = By.id("ap_password_check");
    private By createYourAmazonAccountButtonLocator = By.id("continue");

    //Create new User Account
    public HomePage createNewAccount(String name, String email, String password) {
        typeName(name);
        typeEmail(email);
        typePassword(password);
        typePasswordConfirmation(password);
        driver.findElement(createYourAmazonAccountButtonLocator).click();
        return new HomePage(driver);
    }

    //Fill 'email' field with user's email
    private void typeEmail(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    //Fill 'name' field with user's name
    private void typeName(String name) {
        driver.findElement(nameInputLocator).sendKeys(name);
    }

    //Fill 'password' field with user's password
    private void typePassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    //Fill 'password confirmation' field with user's password
    private void typePasswordConfirmation(String password) {
        driver.findElement(reEnterPasswordInputLocator).sendKeys(password);
    }
}

