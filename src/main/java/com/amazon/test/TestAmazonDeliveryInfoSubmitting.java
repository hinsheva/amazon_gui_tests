package com.amazon.test;


import com.amazon.config.TestInitializer;
import com.amazon.pageObjects.CheckoutDeliveryOptionsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.login;
import static com.amazon.test.TestHelper.submitDeliveryInfoWithItemInCart;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAmazonDeliveryInfoSubmitting extends TestInitializer {

    @BeforeEach
    void beforeMethod(){
        super.setUpBeforeTestMethod();
        login(getHomePage());
    }

    @Test
    void testDeliveryInfoSubmitting() {
        CheckoutDeliveryOptionsPage deliveryOptionsPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver());

        //Check that user is landed to the Delivery Options page after successful delivery info submitting
        assertEquals(getWebAppProperty("title.deliveryOptionsPage"), deliveryOptionsPage.getTitle());
    }
}