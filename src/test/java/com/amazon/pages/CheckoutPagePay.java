package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPagePay {
    private WebDriver driver;

    CheckoutPagePay(WebDriver driver) {
        this.driver = driver;
    }

    private By nameOnCardInputLocator = By.xpath("//*[@id=\"ccName\"]");
    private By cardNumberInputLocator = By.xpath("//*[@id=\"addCreditCardNumber\"]");
    private By expirationMonthDropDown = By.xpath("//select[@id='ccMonth']");
    private By expirationYearDropDown = By.xpath("//select[@id='ccYear']");
    private By addYourCardButtonLocator = By.xpath("//*[@id=\"ccAddCard\"]");
    private By clickContinueButtonLocator = By.xpath("//input[@id='continue-top']");


    public CheckoutPageConfirm fillCreditCardInfo(String name, String cardNumber, String expirationMonth, String expirationYear){
        typeName(name);
        typeCardNumber(cardNumber);
        selectExpirationMonth(expirationMonth);
        selectExpirationYear(expirationYear);
        clickAddYourCardButton();
        clickContinueButton();
        return new CheckoutPageConfirm(driver);
    }

    private void typeName(String name){
        WebElement card = driver.findElement(nameOnCardInputLocator);
        card.click();
        card.clear();
        card.sendKeys(name);
    }

    private void typeCardNumber(String cardNumber){
        WebElement card = driver.findElement(cardNumberInputLocator);
        card.click();
        card.clear();
        card.sendKeys(cardNumber);
    }

    private void selectExpirationMonth(String month) {
        WebElement dropdown = driver.findElement(expirationMonthDropDown);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')",dropdown);

        dropdown.sendKeys(month);
        }

    private void selectExpirationYear(String year) {
        WebElement dropdown = driver.findElement(expirationYearDropDown);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')",dropdown);

        dropdown.sendKeys(year);
        }

    private void clickAddYourCardButton(){
        driver.findElement(addYourCardButtonLocator).click();
    }

    private void clickContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickContinueButtonLocator));
        button.click();
    }
}
