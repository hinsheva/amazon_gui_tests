package com.amazon.test;

import com.amazon.page.*;
import org.openqa.selenium.WebDriver;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static com.amazon.config.PropertiesHolder.getWebAppProperty;

class TestHelper {

    //Methods used in Tests:
    static void login(HomePage homePage) {
        String email = getUserInfoProperty("user.testEmail");
        String password = getUserInfoProperty("user.testPassword");
        String notAuthorizedUserTitle = "Hello. Sign in\n" + "Your Account";

        if (homePage.getTitle().equals(notAuthorizedUserTitle)) {
            homePage.clickSignInLink()
                    .logIn(email, password);
        }
    }

    static CartPage addItemToCart(HomePage homePage, WebDriver driver) {
        String itemName = getUserInfoProperty("item.name");

        homePage.searchForItem(itemName)
                .selectItem()
                .addItemToCart();
        return new CartPage(driver);
    }

    static CheckoutDeliveryOptionsPage submitDeliveryInfoWithItemInCart(HomePage homePage, WebDriver driver) {
        String country = getUserInfoProperty("user.country");
        String userName = getUserInfoProperty("user.name");
        String address = getUserInfoProperty("user.address");
        String city = getUserInfoProperty("user.city");
        String postcode = getUserInfoProperty("user.postcode");
        String phone = getUserInfoProperty("user.testPhone");

        if (!driver.getCurrentUrl().contains(getWebAppProperty("basketPage.url"))) {
            addItemToCart(homePage, driver);
        }
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout()
                .fillAndSubmitDeliveryInfo(country, userName, address, city, postcode, phone);
        return new CheckoutDeliveryOptionsPage(driver);
    }

    static ThankYouPage placeOrder(HomePage homePage, WebDriver driver) {
        String userName = getUserInfoProperty("user.name");
        String cardNumber = getUserInfoProperty("card.testNumber");
        String cardExpMonth = getUserInfoProperty("card.expirationMonth");
        String cardExpYear = getUserInfoProperty("card.expirationYear");

        if (!driver.getCurrentUrl().contains(getWebAppProperty("paymentPage.url"))) {
            submitDeliveryInfoWithItemInCart(homePage, driver)
                    .submitDeliveryOption();
        }
        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.submitPaymentMethod(userName, cardNumber, cardExpMonth, cardExpYear)
                .submitPayment();
        return new ThankYouPage(driver);
    }
}
