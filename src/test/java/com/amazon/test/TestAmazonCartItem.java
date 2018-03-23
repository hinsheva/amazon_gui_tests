package com.amazon.test;

import com.amazon.page.BasePage;
import com.amazon.page.CartPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
import static org.junit.Assert.assertEquals;

public class TestAmazonCartItem extends BasePage{

    @Test
    void testCartItem() {
        CartPage cartPage = addItemToCart();
        cartPage.getItemDetails();
        String expectedItemName = USERINFO_PROPERTIES.getProperty("item.name");
        String actualItemName = cartPage.getItemName();
        String expectedAddedToCartTitle = WEBAPPDATA_PROPERTIES.getProperty("title.itemInTheCart");
        String actualAddedToCartTitle = cartPage.getAddedToCartItemTitle();
        //Check correct item in the cart
        assertEquals(expectedItemName, actualItemName);
        //Check that item of the selected quantity is successfully added to cart
        assertEquals(expectedAddedToCartTitle, actualAddedToCartTitle);
    }
}
