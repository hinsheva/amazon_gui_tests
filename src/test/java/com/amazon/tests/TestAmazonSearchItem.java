package com.amazon.tests;

import com.amazon.Base;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultsPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestAmazonSearchItem extends Base {

    @Test
    void testSearchForItem() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        //Check item name within search results
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("item.name"), searchResultsPage.getTitle());
    }
}

