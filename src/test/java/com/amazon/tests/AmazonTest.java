package com.amazon.tests;

import com.amazon.pages.*;
import com.amazon.settings.Settings;
import org.junit.jupiter.api.Test;

class AmazonTest extends Settings {

    @Test
    void createNewAccount(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        CreateAccountPage createAccountPage = signInPage.clickCreateYourAmazonAccountButton();
        createAccountPage.createNewAccount(userName, userEmail, userPassword).checkUserName(userName);
    }

    @Test
    void checkLoggedInUser() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(userEmail, userPassword).checkUserName(userName);
    }

    @Test
    void checkSearchItem() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForItem(itemName);
        searchResultsPage.checkItemInResults(itemName);
    }

    @Test
    void orderedItem() throws InterruptedException{
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(userEmail, userPassword);
        SearchResultsPage searchResultsPage = homePage.searchForItem(itemName);
        ItemDetailsPage itemDetailsPage =  searchResultsPage.selectItem(itemName);
        CartPage cartPage = itemDetailsPage.addItemToCart();
        CheckoutPageDelivery delivery = cartPage.checkItemAndProceedToCheckout(itemName, successfulTitleForCartAddedItem);
        CheckoutPageDeliveryOptions deliveryOption = delivery.fillAndSubmitDeliveryInfo(userCountry, userName, userAddress, userCity, userPostcode, userPhoneNumber);
        CheckoutPagePay pay = deliveryOption.submitDeliveryOption();
        CheckoutPageConfirm checkoutPageConfirm = pay.fillCreditCardInfo(userName, userCardNumber, cardExpirationMonth, cardExpirationYear);
        checkoutPageConfirm.submitPayment();
        checkoutPageConfirm.checkSuccessfullyPlacedOrder(successTitle);
    }
}
