package com.amazon.test;


import com.amazon.config.TestInitializer;
import com.amazon.page.CheckoutDeliveryOptionsPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.login;
import static com.amazon.test.TestHelper.submitDeliveryInfoWithItemInCart;
import static org.junit.Assert.assertEquals;

class TestAmazonDeliveryInfoSubmitting extends TestInitializer {

    @Test
    void testDeliveryInfoSubmitting() {
        login(getHomePage());
        CheckoutDeliveryOptionsPage deliveryOptionsPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver());
        //Check that user is landed to the Delivery Options page after successful delivery info submitting
        assertEquals(getWebAppProperty("title.deliveryOptionsPage"), deliveryOptionsPage.getTitle());
    }
}