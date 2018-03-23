package com.amazon.test;

import com.amazon.page.BasePage;
import com.amazon.page.CheckoutPaymentPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
import static org.junit.Assert.assertEquals;

public class TestAmazonDeliveryOptionsSubmitting extends BasePage {

    @Test
    void testDeliveryOptionSubmitting() {
        login();
        addItemToCart();
        CheckoutPaymentPage paymentPage = submitDeliveryInfoWithItemInCart().submitDeliveryOption();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.paymentMethodPage");
        String actualPageTitle = paymentPage.getTitle();
        //Check that user is landed to the Payment page after successful delivery option submitting
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
