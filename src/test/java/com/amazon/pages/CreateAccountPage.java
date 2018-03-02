package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.Base.clickElement;
import static com.amazon.Base.inputData;

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
        inputData(nameInputLocator, name);
        inputData(emailInputLocator, email);
        inputData(passwordInputLocator, password);
        inputData(reEnterPasswordInputLocator, password);
        clickElement(createYourAmazonAccountButtonLocator);
        return new HomePage(driver);
    }
}

