package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By signInLinkLocator = By.id("nav-link-yourAccount");
    private By searchFieldLocator = By.id("twotabsearchtextbox");
    private By searchButtonLocator = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private By userAccountNameTextLocator = By.id("nav-link-yourAccount");

    //Press button to see the SignIn/LogIn form/page
    public SignInPage clickSignInLink() {
        clickElement(signInLinkLocator);
        return new SignInPage(driver);
    }

    //Get search results for the query(item name)
    public SearchResultsPage searchForItem(String itemName) {
        inputData(searchFieldLocator, itemName);
        clickElement(searchButtonLocator);
        return new SearchResultsPage(driver);
    }

    public String getTitle() {
        return getElementText(userAccountNameTextLocator);
    }

}