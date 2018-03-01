package com.amazon.tests;

import com.amazon.Settings;
import com.amazon.pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestSmokeAmazon extends Settings {

    @Test
    void testFullOrderProcess() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"), USERINFO_PROPERTIES.getProperty("user.testPassword"));

        //Check user name on the home page after login
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());

        SearchResultsPage searchResultsPage = homePage.searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        ItemDetailsPage itemDetailsPage = searchResultsPage.selectItem();
        CartPage cartPage = itemDetailsPage.addItemToCart();
        cartPage.getItemDetails();

        //Check item name within search results
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("item.name"), cartPage.getItemName());

        //Check that item was successfully added to cart
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("title.itemInTheCart"), cartPage.getAddedToCartItemTitle());

        CheckoutPageDelivery deliveryPage = cartPage.proceedToCheckout();
        CheckoutPageDeliveryOptions deliveryOption = deliveryPage.fillAndSubmitDeliveryInfo(USERINFO_PROPERTIES.getProperty("user.country"),
                USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("user.address"), USERINFO_PROPERTIES.getProperty("user.city"),
                USERINFO_PROPERTIES.getProperty("user.postcode"), USERINFO_PROPERTIES.getProperty("user.testPhone"));
        CheckoutPagePay paymentPage = deliveryOption.submitDeliveryOption();
        CheckoutPageConfirm orderConfirmationPage = paymentPage.fillCreditCardInfo(USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("card.testNumber"),
                USERINFO_PROPERTIES.getProperty("card.expirationMonth"), USERINFO_PROPERTIES.getProperty("card.expirationYear"));
        orderConfirmationPage.submitPayment();

        //Check successful title about placed order on the home page
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("title.successfulOrder"), orderConfirmationPage.getTitle());
    }
}
