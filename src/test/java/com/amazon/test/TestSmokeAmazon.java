//package com.amazon.test;
//
//import com.amazon.config.TestInitializer;
//import com.amazon.page.*;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
//import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
//import static com.amazon.test.TestHelper.*;
//
//public class TestSmokeAmazon extends TestInitializer {
//
//    @Test
//    void testLogin() {
//        String userName = USERINFO_PROPERTIES.getProperty("user.name");
//        String authorizedUserTitle = "Hello, " + userName + "\nYour Account";
//        login(getHomePage());
//
//        Assert.assertEquals(authorizedUserTitle, getHomePage().getTitle());
//    }
//
//    @Test
//    void testSearch() {
//        String expectedItemName = USERINFO_PROPERTIES.getProperty("item.name");
//        String actualItemName = getHomePage().searchForItem(expectedItemName).getItemName();
//        getHomePage().searchForItem(expectedItemName);
//
//        Assert.assertEquals(expectedItemName, actualItemName);
//    }
//
//    @Test
//    void testCartItem() {
//        CartPage cartPage = addItemToCart(getHomePage(), getDriver());
//        cartPage.getItemDetails();
//        String expectedItemName = USERINFO_PROPERTIES.getProperty("item.name");
//        String actualItemName = cartPage.getItemName();
//        String expectedAddedToCartTitle = WEBAPPDATA_PROPERTIES.getProperty("title.itemInTheCart");
//        String actualAddedToCartTitle = cartPage.getAddedToCartItemTitle();
//
//        Assert.assertEquals(expectedItemName, actualItemName);
//        Assert.assertEquals(expectedAddedToCartTitle, actualAddedToCartTitle);
//    }
//
//    @Test
//    void testDeliveryInfoSubmitting() {
//        login();
//        CheckoutDeliveryOptionsPage deliveryOptionsPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver());
//        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.deliveryOptionsPage");
//        String actualPageTitle = deliveryOptionsPage.getTitle();
//
//        Assert.assertEquals(expectedPageTitle, actualPageTitle);
//    }
//
//    @Test
//    void testDeliveryOptionSubmitting() {
//        login(getHomePage());
//        addItemToCart(getHomePage(), getDriver());
//        CheckoutPaymentPage paymentPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver()).submitDeliveryOption();
//        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.paymentMethodPage");
//        String actualPageTitle = paymentPage.getTitle();
//
//        Assert.assertEquals(expectedPageTitle, actualPageTitle);
//    }
//
//    @Test
//    void testPlaceOrder() {
//        login(getHomePage());
//        addItemToCart(getHomePage(), getDriver());
//        ThankYouPage thankYouPage = placeOrder(getHomePage(), getDriver());
//        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.successfulOrder");
//        String actualPageTitle = thankYouPage.getPlacedOrderTitle();
//        String expectedOrderTitle = WEBAPPDATA_PROPERTIES.getProperty("title.orderNumber");
//        String actualOrderTitle = thankYouPage.getOrderInfo();
//
//        Assert.assertEquals(expectedPageTitle, actualPageTitle);
//        Assert.assertEquals(expectedOrderTitle, actualOrderTitle);
//    }
//}
