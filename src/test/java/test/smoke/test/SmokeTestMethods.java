package test.smoke.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by HINSHEVA on 7/17/2017.
 */
public class SmokeTestMethods {
    private WebDriver driver;

    public SmokeTestMethods(WebDriver driver) {
        this.driver = driver;
    }


    public void logIn(String user, String pass, String loginSelector) {
        WebElement loginField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        loginField.clear();
        loginField.sendKeys(user);
        passwordField.clear();
        passwordField.sendKeys(pass);
        WebElement singIn = driver.findElement(By.cssSelector(loginSelector));
        singIn.click();
    }

    public void closeModal(String modalSelector){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(modalSelector)));
        WebElement modalClose = driver.findElement(By.cssSelector(modalSelector));
        modalClose.click();
        wait.until(ExpectedConditions.invisibilityOf(modalClose));
    }

    public void clickElement(String tabLink, String tabUrl) {
        driver.findElement(By.linkText(tabLink)).click();
        Assert.assertEquals(tabUrl, driver.getCurrentUrl());
    }

    public void logOut(String logoutSelector, String buttonLink, String logoutUrl){
        WebElement userLogOut = driver.findElement(By.cssSelector(logoutSelector));
        userLogOut.click();
        WebElement logOut = driver.findElement(By.linkText(buttonLink));
        logOut.click();
        Assert.assertEquals(logoutUrl, driver.getCurrentUrl());

    }

}
