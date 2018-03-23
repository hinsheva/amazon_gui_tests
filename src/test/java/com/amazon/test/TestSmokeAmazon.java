package com.amazon.test;

import com.amazon.page.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;

public class TestSmokeAmazon extends BasePage {

    @Test
    void testLogin() {
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String authorizedUserTitle = "Hello, " + userName + "\nYour Account";
        login();

        Assert.assertEquals(authorizedUserTitle, getHomePage().getTitle());
    }

    @Test
    void testSearch() {
        String expectedItemName = USERINFO_PROPERTIES.getProperty("item.name");
        String actualItemName = getHomePage().searchForItem(expectedItemName).getItemName();
        getHomePage().searchForItem(expectedItemName);

        Assert.assertEquals(expectedItemName, actualItemName);
    }

    @Test
    void testCartItem() {
        CartPage cartPage = addItemToCart();
        cartPage.getItemDetails();
        String expectedItemName = USERINFO_PROPERTIES.getProperty("item.name");
        String actualItemName = cartPage.getItemName();
        String expectedAddedToCartTitle = WEBAPPDATA_PROPERTIES.getProperty("title.itemInTheCart");
        String actualAddedToCartTitle = cartPage.getAddedToCartItemTitle();

        Assert.assertEquals(expectedItemName, actualItemName);
        Assert.assertEquals(expectedAddedToCartTitle, actualAddedToCartTitle);
    }

    @Test
    void testDeliveryInfoSubmitting() {
        login();
        CheckoutDeliveryOptionsPage deliveryOptionsPage = submitDeliveryInfoWithItemInCart();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.deliveryOptionsPage");
        String actualPageTitle = deliveryOptionsPage.getTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Test
    void testDeliveryOptionSubmitting() {
        login();
        addItemToCart();
        CheckoutPaymentPage paymentPage = submitDeliveryInfoWithItemInCart().submitDeliveryOption();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.paymentMethodPage");
        String actualPageTitle = paymentPage.getTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Test
    void testPlaceOrder() {
        login();
        addItemToCart();
        HomePage homePage = placeOrder();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.successfulOrder");
        String actualPageTitle = homePage.getPlacedOrderTitle();
        String expectedOrderTitle = WEBAPPDATA_PROPERTIES.getProperty("title.orderNumber");
        String actualOrderTitle = homePage.getOrderInfo();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        Assert.assertEquals(expectedOrderTitle, actualOrderTitle);
    }
}
