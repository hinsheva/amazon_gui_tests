package com.amazon.test;

import com.amazon.page.CartPage;
import com.amazon.page.CheckoutDeliveryOptionsPage;
import com.amazon.page.HomePage;
import com.amazon.page.ThankYouPage;
import org.openqa.selenium.WebDriver;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;

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

        addItemToCart(homePage,driver)
                .proceedToCheckout()
                .fillAndSubmitDeliveryInfo(country, userName, address, city, postcode, phone);
        return new CheckoutDeliveryOptionsPage(driver);
    }

    static ThankYouPage placeOrder(HomePage homePage, WebDriver driver) {
        String userName = getUserInfoProperty("user.name");
        String cardNumber = getUserInfoProperty("card.testNumber");
        String cardExpMonth = getUserInfoProperty("card.expirationMonth");
        String cardExpYear = getUserInfoProperty("card.expirationYear");

        submitDeliveryInfoWithItemInCart(homePage, driver)
                .submitDeliveryOption()
                .submitPaymentMethod(userName, cardNumber, cardExpMonth, cardExpYear)
                .submitPayment();

        return new ThankYouPage(driver);
    }
}
