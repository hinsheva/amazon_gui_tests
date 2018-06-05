package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.pageObjects.CartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.addItemToCart;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestAmazonCartItem extends TestInitializer {
    private CartPage cartPage;

    @BeforeEach
    protected void setUpBeforeTestMethod(){
        super.setUpBeforeTestMethod();
        cartPage = addItemToCart(getHomePage(), getDriver());
    }

    @Test
    void testCartItem() {
        cartPage.getItemDetails();

        //Check correct item in the cart
        assertTrue(getUserInfoProperty("item.name").contains(cartPage.getItemName()));

        //Check that item of the selected quantity is successfully added to cart
        assertEquals(getWebAppProperty("title.itemInTheCart"), cartPage.getAddedToCartItemTitle());
    }
}
