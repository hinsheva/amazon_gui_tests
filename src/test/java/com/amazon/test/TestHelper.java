package com.amazon.test;

import com.amazon.page.CartPage;
import com.amazon.page.CheckoutDeliveryOptionsPage;
import com.amazon.page.HomePage;
import com.amazon.page.ThankYouPage;
import org.openqa.selenium.WebDriver;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;

class TestHelper {

    //Methods used in Tests:
    static void login(HomePage homePage) {
        String email = USERINFO_PROPERTIES.getProperty("user.testEmail");
        String password = USERINFO_PROPERTIES.getProperty("user.testPassword");
        String notAuthorizedUserTitle = "Hello. Sign in\n" + "Your Account";

        if (homePage.getTitle().equals(notAuthorizedUserTitle)) {
            homePage.clickSignInLink()
                    .logIn(email, password);
        }
    }

    static CartPage addItemToCart(HomePage homePage, WebDriver driver) {
        String itemName = USERINFO_PROPERTIES.getProperty("item.name");

        homePage.searchForItem(itemName)
                .selectItem()
                .addItemToCart();
        return new CartPage(driver);
    }

    static CheckoutDeliveryOptionsPage submitDeliveryInfoWithItemInCart(HomePage homePage, WebDriver driver) {
        String country = USERINFO_PROPERTIES.getProperty("user.country");
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String address = USERINFO_PROPERTIES.getProperty("user.address");
        String city = USERINFO_PROPERTIES.getProperty("user.city");
        String postcode = USERINFO_PROPERTIES.getProperty("user.postcode");
        String phone = USERINFO_PROPERTIES.getProperty("user.testPhone");

        addItemToCart(homePage,driver)
                .proceedToCheckout()
                .fillAndSubmitDeliveryInfo(country, userName, address, city, postcode, phone);
        return new CheckoutDeliveryOptionsPage(driver);
    }

    static ThankYouPage placeOrder(HomePage homePage, WebDriver driver) {
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String cardNumber = USERINFO_PROPERTIES.getProperty("card.testNumber");
        String cardExpMonth = USERINFO_PROPERTIES.getProperty("card.expirationMonth");
        String cardExpYear = USERINFO_PROPERTIES.getProperty("card.expirationYear");

        submitDeliveryInfoWithItemInCart(homePage, driver)
                .submitDeliveryOption()
                .submitPaymentMethod(userName, cardNumber, cardExpMonth, cardExpYear)
                .submitPayment();

        return new ThankYouPage(driver);
    }
}
