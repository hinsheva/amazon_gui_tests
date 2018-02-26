package com.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    private By signInLinkLocator = By.xpath("//*[@id=\"nav-link-yourAccount\"]");
    private By searchFieldLocator = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    private By searchButtonLocator = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private By userAccountName = By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]");

    public SignInPage clickSignInLink(){
        driver.findElement(signInLinkLocator).click();
        return new SignInPage(driver);
    }

    public SearchResultsPage searchForItem(String itemName) throws InterruptedException {
        WebElement search = driver.findElement(searchFieldLocator);
        search.click();
        search.clear();
        search.sendKeys(itemName);
        runSearch();
        return new SearchResultsPage(driver);
    }

    public void checkUserName(String userName){
        Assert.assertEquals("Hello, " + userName, driver.findElement(userAccountName).getText());
    }

    private void runSearch() {
        driver.findElement(searchButtonLocator).click();
    }


}
