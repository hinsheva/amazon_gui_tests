package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    private WebDriver driver;

    CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInputLocator = By.xpath("//*[@id=\"ap_customer_name\"]");
    private By emailInputLocator = By.xpath("//*[@id=\"ap_email\"]");
    private By passwordInputLocator = By.xpath("//*[@id=\"ap_password\"]");
    private By reEnterPasswordInputLocator = By.xpath("//*[@id=\"ap_password_check\"]");
    private By createYourAmazonAccountButtonLocator = By.xpath("//*[@id=\"continue\"]");

    public HomePage createNewAccount(String name, String email, String password) {
        typeName(name);
        typeEmail(email);
        typePassword(password);
        typePasswordConfirmation(password);
        driver.findElement(createYourAmazonAccountButtonLocator).click();
        return new HomePage(driver);
    }

    private void typeEmail(String email) {
        WebElement login = driver.findElement(emailInputLocator);
        login.click();
        login.clear();
        login.sendKeys(email);
    }

    private void typeName(String name) {
        WebElement login = driver.findElement(nameInputLocator);
        login.click();
        login.clear();
        login.sendKeys(name);
    }

    private void typePassword(String password) {
        WebElement login = driver.findElement(passwordInputLocator);
        login.click();
        login.clear();
        login.sendKeys(password);
    }

    private void typePasswordConfirmation(String password) {
        WebElement login = driver.findElement(reEnterPasswordInputLocator);
        login.click();
        login.clear();
        login.sendKeys(password);
    }
}

