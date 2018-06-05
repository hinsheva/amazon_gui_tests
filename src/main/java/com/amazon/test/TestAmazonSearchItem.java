package com.amazon.test;

import com.amazon.config.TestInitializer;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestAmazonSearchItem extends TestInitializer {

    @Test
    void testSearch() {
        String actualItemName = getHomePage()
                .searchForItem(getUserInfoProperty("item.name"))
                .getItemName();

        //Check search results per the query
        assertTrue(getUserInfoProperty("item.name").contains(actualItemName));
    }
}