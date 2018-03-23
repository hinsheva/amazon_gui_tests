package com.amazon.test;


import com.amazon.page.BasePage;
import com.amazon.page.CheckoutDeliveryOptionsPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
import static org.junit.Assert.assertEquals;

class TestAmazonDeliveryInfoSubmitting extends BasePage {

    @Test
    void testDeliveryInfoSubmitting() {
        login();
        CheckoutDeliveryOptionsPage deliveryOptionsPage = submitDeliveryInfoWithItemInCart();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.deliveryOptionsPage");
        String actualPageTitle = deliveryOptionsPage.getTitle();
        //Check that user is landed to the Delivery Options page after successful delivery info submitting
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}