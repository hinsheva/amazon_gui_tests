package com.amazon.page;

import com.amazon.config.ChromeBrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends ChromeBrowserDriver {

    static void clickElement(By locator) {
        getElement(locator).click();
    }

    static void inputData(By locator, String inputData) {
        getElement(locator).sendKeys(inputData);
    }

    static String getElementText(By locator) {
        return getElement(locator).getText();
    }

    static WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    static void waitUntilElementDisappears(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    static void selectDropDownValue(By locator, String text) {
        Select value = new Select(getElement(locator));
        value.selectByVisibleText(text);
    }

    static void setJsDropDownOption(By locator, String optionText) {
        WebElement dropDown = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", dropDown);
        dropDown.sendKeys(optionText);
    }
}
