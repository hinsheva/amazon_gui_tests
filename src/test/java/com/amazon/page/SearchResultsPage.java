package com.amazon.page;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {

    private By itemImageLinkLocator = By.xpath("/descendant::div[@id='atfResults']/descendant::img[1]");
    private By itemNameLocator = By.xpath("//h2[@data-attribute='Silver Bay: A Novel by Jojo Moyes (2014-08-26)']");

    //Click on item information to navigate to the Item Details Page
    public ItemDetailsPage selectItem() {
        clickElement(itemImageLinkLocator);
        return new ItemDetailsPage();
    }

    public String getItemName() {
        return getElementText(itemNameLocator);
    }
}