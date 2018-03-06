package com.amazon.test;

import com.amazon.config.ChromeBrowserDriver;
import com.amazon.page.SearchResultsPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;

class TestAmazonSearchItem extends ChromeBrowserDriver {

    @Test
    void testSearchForItem() {
        SearchResultsPage searchResultsPage = homePage.searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        //Check item name within search results
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("item.name"), searchResultsPage.getTitle());
    }
}