package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.pageObjects.CheckoutPaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAmazonDeliveryOptionsSubmitting extends TestInitializer{

    @BeforeEach
    void beforeMethod(){
        super.setUpBeforeTestMethod();
        login(getHomePage());
        addItemToCart(getHomePage(), getDriver());
    }

    @Test
    void testDeliveryOptionSubmitting() {
        CheckoutPaymentPage paymentPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver())
                .submitDeliveryOption();

        //Check that user is landed to the Payment page after successful delivery option submitting
        assertEquals(getWebAppProperty("title.paymentMethodPage"), paymentPage.getTitle());
    }
}
