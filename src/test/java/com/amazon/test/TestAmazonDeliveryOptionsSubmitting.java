package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.page.CheckoutPaymentPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.*;
import static org.junit.Assert.assertEquals;

class TestAmazonDeliveryOptionsSubmitting extends TestInitializer{

    @Test
    void testDeliveryOptionSubmitting() {
        login(getHomePage());
        addItemToCart(getHomePage(), getDriver());
        CheckoutPaymentPage paymentPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver()).submitDeliveryOption();
        //Check that user is landed to the Payment page after successful delivery option submitting
        assertEquals(getWebAppProperty("title.paymentMethodPage"), paymentPage.getTitle());
    }
}
