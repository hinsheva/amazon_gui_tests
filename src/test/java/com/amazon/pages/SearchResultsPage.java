package com.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemImageLinkLocator = By.xpath("/descendant::div[@id='atfResults']/descendant::img[1]");
    private By itemNameLocator = By.xpath("//h2[@data-attribute='Silver Bay: A Novel by Jojo Moyes (2014-08-26)']");

    public ItemDetailsPage selectItem(String itemName){
        checkItemInResults(itemName);
        driver.findElement(itemImageLinkLocator).click();
        return new ItemDetailsPage(driver);
    }

    public void checkItemInResults(String itemName) {
        Assert.assertEquals(itemName, driver.findElement(itemNameLocator).getText());
    }
}
