package com.amazon.test;

import com.amazon.page.BasePage;
import com.amazon.page.HomePage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.WEBAPPDATA_PROPERTIES;
import static org.junit.Assert.assertEquals;

public class TestAmazonPlaceOrder extends BasePage {

    @Test
    void testPlaceOrder() {
        login();
        addItemToCart();
        HomePage homePage = placeOrder();
        String expectedPageTitle = WEBAPPDATA_PROPERTIES.getProperty("title.successfulOrder");
        String actualPageTitle = homePage.getPlacedOrderTitle();
        //Check that user is landed to the Home page with the success block after successfully payment info submitting
        assertEquals(expectedPageTitle, actualPageTitle);

        String expectedOrderTitle = WEBAPPDATA_PROPERTIES.getProperty("title.orderNumber");
        String actualOrderTitle = homePage.getOrderInfo();
        //Check placed order info displaying
        assertEquals(expectedOrderTitle, actualOrderTitle);
    }
}
