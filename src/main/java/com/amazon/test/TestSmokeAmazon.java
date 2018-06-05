package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.pageObjects.CartPage;
import com.amazon.pageObjects.CheckoutDeliveryOptionsPage;
import com.amazon.pageObjects.CheckoutPaymentPage;
import com.amazon.pageObjects.ThankYouPage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static com.amazon.config.PropertiesHolder.getWebAppProperty;
import static com.amazon.test.TestHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestSmokeAmazon extends TestInitializer {

    @Test
    void testLogin() {
        String authorizedUserTitle = "Hello, " + getUserInfoProperty("user.name") + "\nYour Account";
        login(getHomePage());
        //Check user name on the home page after login
        assertEquals(authorizedUserTitle, getHomePage().getTitle());
    }

    @Test
    void testSearch() {
        String actualItemName = getHomePage().searchForItem(getUserInfoProperty("item.name")).getItemName();
        //Check search results per the query
        assertTrue(getUserInfoProperty("item.name").contains(actualItemName));
    }

    @Nested
    class CartItem {
        @Test
        void testCartItem() {
            CartPage cartPage = addItemToCart(getHomePage(), getDriver());
            cartPage.getItemDetails();
            //Check correct item in the cart
            assertTrue(getUserInfoProperty("item.name").contains(cartPage.getItemName()));
            //Check that item of the selected quantity is successfully added to cart
            assertEquals(getWebAppProperty("title.itemInTheCart"), cartPage.getAddedToCartItemTitle());
        }

        @Nested
        class DeliveryInfo {
            @Test
            void testDeliveryInfoSubmitting() {
                CheckoutDeliveryOptionsPage deliveryOptionsPage = submitDeliveryInfoWithItemInCart(getHomePage(), getDriver());
                //Check that user is landed to the Delivery Options page after successful delivery info submitting
                assertEquals(getWebAppProperty("title.deliveryOptionsPage"), deliveryOptionsPage.getTitle());
            }

            @Nested
            class DeliveryOptions {
                @Test
                void testDeliveryOptionsSubmitting() {
                    CheckoutDeliveryOptionsPage deliveryOptionsPage = new CheckoutDeliveryOptionsPage(getDriver());
                    CheckoutPaymentPage paymentPage = deliveryOptionsPage.submitDeliveryOption();
                    //Check that user is landed to the Payment page after successful delivery option submitting
                    assertEquals(getWebAppProperty("title.paymentMethodPage"), paymentPage.getTitle());
                }

                @Nested
                class PaymentAndPlaceOrder {
                    @Test
                    void testPaymentInfoSubmittingAndOrderPlacing() {
                        ThankYouPage thankYouPage = placeOrder(getHomePage(), getDriver());
                        //Check that user is landed to the Home page with the success block after successfully payment info submitting
                        assertEquals(getWebAppProperty("title.successfulOrder"), thankYouPage.getPlacedOrderTitle());
                        //Check placed order info displaying
                        assertEquals(getWebAppProperty("title.orderNumber"), thankYouPage.getOrderInfo());
                    }
                }
            }
        }
    }
}
