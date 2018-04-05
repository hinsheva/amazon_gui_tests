package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.page.CheckoutPaymentPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
import static com.amazon.test.TestHelper.addItemToCart;
import static com.amazon.test.TestHelper.login;
import static com.amazon.test.TestHelper.submitDeliveryInfoWithItemInCart;
import static org.junit.Assert.assertEquals;

class TestAmazonDeliveryOptionsSubmitting extends TestInitializer{

    @Test
    void testDeliveryOptionSubmitting() {
        login(getHomePage());
        addItemToCart(getHomePage(), getDriver());
        CheckoutPaymentPage paymentPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver()).submitDeliveryOption();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.paymentMethodPage");
        String actualPageTitle = paymentPage.getTitle();
        //Check that user is landed to the Payment page after successful delivery option submitting
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
