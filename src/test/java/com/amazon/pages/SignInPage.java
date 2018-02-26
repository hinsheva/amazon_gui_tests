package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    private WebDriver driver;

    SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createYourAmazonAccountButtonLocator = By.xpath("//*[@id=\"createAccountSubmit\"]");
    private By emailInputLocator = By.xpath("//*[@id=\"ap_email\"]");
    private By passwordInputLocator = By.xpath("//*[@id=\"ap_password\"]");
    private By continueButtonLocator = By.xpath("//*[@id=\"continue\"]");
    private By signInButtonLocator = By.xpath("//*[@id=\"signInSubmit\"]");


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

    public CreateAccountPage clickCreateYourAmazonAccountButton(){
        driver.findElement(createYourAmazonAccountButtonLocator).click();
        return new CreateAccountPage(driver);
    }

    private void typeEmail(String email) {
        WebElement login = driver.findElement(emailInputLocator);
        login.click();
        login.clear();
        login.sendKeys(email);
    }

    private void clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
    }

    private void typePassword(String password) {
        WebElement login = driver.findElement(passwordInputLocator);
        login.click();
        login.clear();
        login.sendKeys(password);
    }

    private void clickSignInButton() {
        driver.findElement(signInButtonLocator).click();
    }
}
