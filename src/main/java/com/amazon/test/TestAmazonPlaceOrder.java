package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.pageObjects.ThankYouPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAmazonPlaceOrder extends TestInitializer{

    @BeforeEach
    void beforeMethod(){
        super.setUpBeforeTestMethod();
        login(getHomePage());
        addItemToCart(getHomePage(), getDriver());
    }

    @Test
    void testPlaceOrder() {
        ThankYouPage thankYouPage = placeOrder(getHomePage(), getDriver());

        //Check that user is landed to the Home page with the success block after successfully payment info submitting
        assertEquals(getWebAppProperty("title.successfulOrder"), thankYouPage.getPlacedOrderTitle());

        //Check placed order info displaying
        assertEquals(getWebAppProperty("title.orderNumber"), thankYouPage.getOrderInfo());
    }
}
