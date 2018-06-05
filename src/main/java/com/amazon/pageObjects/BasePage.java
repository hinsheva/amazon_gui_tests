package com.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void clickElement(By locator) {
        getElement(locator).click();
    }

    void inputData(By locator, String inputData) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(inputData);
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

    void clickTableCellValue(By locatorTable, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTable));

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().contains(value))
                    cell.findElement(By.xpath("//*/text()[normalize-space(.)='" + value + "']/parent::*")).click();

            }
        }
    }
}

