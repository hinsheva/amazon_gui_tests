package com.amazon.test;


import com.amazon.config.ChromeBrowserDriver;
import com.amazon.page.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;

class TestAmazonDeliveryPage extends ChromeBrowserDriver {

    @Test
    void testDeliveryInfoSubmitting() {
        SignInPage signInPage = homePage.clickSignInLink();
        SearchResultsPage searchResultsPage = signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"),
                USERINFO_PROPERTIES.getProperty("user.testPassword")).searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        ItemDetailsPage itemDetailsPage = searchResultsPage.selectItem();
        CartPage cartPage = itemDetailsPage.addItemToCart();
        CheckoutPageDelivery deliveryPage = cartPage.proceedToCheckout();
        CheckoutPageDeliveryOptions deliveryOption = deliveryPage.fillAndSubmitDeliveryInfo(USERINFO_PROPERTIES.getProperty("user.country"),
                USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("user.address"), USERINFO_PROPERTIES.getProperty("user.city"),
                USERINFO_PROPERTIES.getProperty("user.postcode"), USERINFO_PROPERTIES.getProperty("user.testPhone"));
        //Check that user is landed to the Delivery Options page after submitting delivery info
        Assert.assertEquals(WEBAPPDATA_PROPERTIES.getProperty("title.deliveryOptionsPage"), deliveryOption.getTitle());
    }
}