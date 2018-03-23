package com.amazon.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By signInLinkLocator = By.id("nav-link-yourAccount");
    private By searchFieldLocator = By.id("twotabsearchtextbox");
    private By searchButtonLocator = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private By userAccountNameTextLocator = By.id("nav-link-yourAccount");

    private By yourOrderHasBeenPlacedTitleLocator = By.xpath("//h2[@class='a-color-success']");
    private By orderNumberTitleLocator = By.xpath("//h5[contains(text(),'Order Number:')]");

    //Press button to see the SignIn/LogIn form/page
    public SignInPage clickSignInLink() {
        clickElement(signInLinkLocator);
        return new SignInPage();
    }

    //Get search results for the query(item name)
    public SearchResultsPage searchForItem(String itemName) {
        inputData(searchFieldLocator, itemName);
        clickElement(searchButtonLocator);
        return new SearchResultsPage();
    }

    public String getTitle() {
        return getElementText(userAccountNameTextLocator);
    }

    public String getPlacedOrderTitle() {
        return getElementText(yourOrderHasBeenPlacedTitleLocator);
    }

    public String getOrderInfo(){
        return getElementText(orderNumberTitleLocator).split(":")[0];
    }
}