package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.page.ThankYouPage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
import static com.amazon.test.TestHelper.addItemToCart;
import static com.amazon.test.TestHelper.login;
import static com.amazon.test.TestHelper.placeOrder;
import static org.junit.Assert.assertEquals;

class TestAmazonPlaceOrder extends TestInitializer{

    @Test
    void testPlaceOrder() {
        login(getHomePage());
        addItemToCart(getHomePage(), getDriver());
        ThankYouPage thankYouPage = placeOrder(getHomePage(), getDriver());
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.successfulOrder");
        String actualPageTitle = thankYouPage.getPlacedOrderTitle();
        //Check that user is landed to the Home page with the success block after successfully payment info submitting
        assertEquals(expectedPageTitle, actualPageTitle);

        String expectedOrderTitle = WEBAPPDATA_PROPERTIES.getProperty("title.orderNumber");
        String actualOrderTitle = thankYouPage.getOrderInfo();
        //Check placed order info displaying
        assertEquals(expectedOrderTitle, actualOrderTitle);
    }
}
