package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void clickElement(By locator) {
        getElement(locator).click();
    }

    void inputData(By locator, String inputData) {
        getElement(locator).sendKeys(inputData);
    }

    String getElementText(By locator) {
        return getElement(locator).getText();
    }

    WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    void waitUntilElementDisappears(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    void selectDropDownValue(By locator, String text) {
        Select value = new Select(getElement(locator));
        value.selectByVisibleText(text);
    }

    void setJsDropDownOption(By locator, String optionText) {
        WebElement dropDown = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", dropDown);
        dropDown.sendKeys(optionText);
    }
}

