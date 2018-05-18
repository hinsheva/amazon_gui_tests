package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private By itemImageLinkLocator = By.xpath("/descendant::div[@id='atfResults']/descendant::img[1]");
    private By itemNameLocator = By.xpath("//h2[@data-attribute='Silver Bay']");

    //Click on item information to navigate to the Item Details Page
    public ItemDetailsPage selectItem() {
        clickElement(itemImageLinkLocator);
        return new ItemDetailsPage(driver);
    }

    public String getItemName() {
        return getElementText(itemNameLocator);
    }
}