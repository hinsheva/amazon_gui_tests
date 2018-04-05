package com.amazon.test;

import com.amazon.config.TestInitializer;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static org.junit.Assert.assertEquals;

class TestAmazonSearchItem extends TestInitializer {

    @Test
    void testSearch() {
        String expectedItemName = USERINFO_PROPERTIES.getProperty("item.name");
        String actualItemName = getHomePage().searchForItem(expectedItemName).getItemName();
        getHomePage().searchForItem(expectedItemName);
        //Check search results per the query
        assertEquals(expectedItemName, actualItemName);
    }
}