package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInLinkLocator = By.id("nav-link-yourAccount");
    private By searchFieldLocator = By.id("twotabsearchtextbox");
    private By searchButtonLocator = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private By userAccountName = By.id("nav-link-yourAccount");

    //Press button to see the SignIn/LogIn form/page
    public SignInPage clickSignInLink() {
        driver.findElement(signInLinkLocator).click();
        return new SignInPage(driver);
    }

    //Get search results for the query(item name)
    public SearchResultsPage searchForItem(String itemName) {
        driver.findElement(searchFieldLocator).sendKeys(itemName);
        runSearch();
        return new SearchResultsPage(driver);
    }

    //Press button to run the search
    private void runSearch() {
        driver.findElement(searchButtonLocator).click();
    }

    public String getTitle() {
        return driver.findElement(userAccountName).getText();
    }
}
