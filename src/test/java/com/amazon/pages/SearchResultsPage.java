package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.amazon.Base.clickElement;
import static com.amazon.Base.getElementText;

public class SearchResultsPage {
    private WebDriver driver;

    SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemImageLinkLocator = By.xpath("/descendant::div[@id='atfResults']/descendant::img[1]");
    private By itemNameLocator = By.xpath("//h2[@data-attribute='Silver Bay: A Novel by Jojo Moyes (2014-08-26)']");

    //Click on item information to navigate to the Item Details Page
    public ItemDetailsPage selectItem() {
        clickElement(itemImageLinkLocator);
        return new ItemDetailsPage(driver);
    }

    public String getTitle() {
        return getElementText(itemNameLocator);
    }
}
