package com.amazon.tests;

import com.amazon.Settings;
import com.amazon.pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestAmazonDeliveryPage extends Settings {

    @Test
    void testDeliveryInfoSubmitting(){
        HomePage homePage = new HomePage(driver);
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
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("title.deliveryOptionsPage"), deliveryOption.getTitle());
    }
}

