package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.page.CartPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.*;
import static com.amazon.test.TestHelper.addItemToCart;
import static org.junit.Assert.assertEquals;

class TestAmazonCartItem extends TestInitializer {

    @Test
    void testCartItem() {
        CartPage cartPage = addItemToCart(getHomePage(), getDriver());
        cartPage.getItemDetails();
        //Check correct item in the cart
        assertEquals(getUserInfoProperty("item.name"), cartPage.getItemName());
        //Check that item of the selected quantity is successfully added to cart
        assertEquals(getWebAppProperty("title.itemInTheCart"), cartPage.getAddedToCartItemTitle());
    }
}
