package com.amazon.test;

import com.amazon.config.ChromeBrowserDriver;

class TestAmazon extends ChromeBrowserDriver {

/*    @Test
    void testLogIn() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"), USERINFO_PROPERTIES.getProperty("user.testPassword"));
        //Check user name on the home page after login
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());
    }

    @Test
    void testNewAccountCreation() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        CreateAccountPage createAccountPage = signInPage.clickCreateYourAmazonAccountButton();
        createAccountPage.createNewAccount(USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("user.testEmail"),
                USERINFO_PROPERTIES.getProperty("user.testPassword"));
        //Check user name on the home page after account creation
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());
    }

    @Test
    void testSearchForItem() {
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        //Check item name within search results
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("item.name"), searchResultsPage.getTitle());
    }

    @Test
    void testDeliveryInfoSubmitting(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        SearchResultsPage searchResultsPage = signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"),
                USERINFO_PROPERTIES.getProperty("user.testPassword")).searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        ItemDetailsPage itemDetailsPage = searchResultsPage.selectItem();
        CartPage cartPage = itemDetailsPage.addItemToCart();
        CheckoutPageDelivery deliveryPage = cartPage.proceedToCheckout();
        CheckoutPageDeliveryOptions deliveryOption = deliveryPage.fillAndSubmitDeliveryInfo(USERINFO_PROPERTIES.getProperty("user.country"),
                USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("user.address"), USERINFO_PROPERTIES.getProperty("user.city"),
                USERINFO_PROPERTIES.getProperty("user.postcode"), USERINFO_PROPERTIES.getProperty("user.testPhone"));
        //Check that user is landed to the Delivery Options page after submitting delivery info
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("title.deliveryOptionsPage"), deliveryOption.getTitle());
    }

    @Test
    void testFullOrderProcess() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"), USERINFO_PROPERTIES.getProperty("user.testPassword"));
        //Check user name on the home page after login
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());

        SearchResultsPage searchResultsPage = homePage.searchForItem(USERINFO_PROPERTIES.getProperty("item.name"));
        ItemDetailsPage itemDetailsPage = searchResultsPage.selectItem();
        CartPage cartPage = itemDetailsPage.addItemToCart();
        cartPage.getItemDetails();
        //Check item name within search results
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("item.name"), cartPage.getItemName());

        //Check that item was successfully added to cart
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("title.itemInTheCart"), cartPage.getAddedToCartItemTitle());

        CheckoutPageDelivery deliveryPage = cartPage.proceedToCheckout();
        CheckoutPageDeliveryOptions deliveryOption = deliveryPage.fillAndSubmitDeliveryInfo(USERINFO_PROPERTIES.getProperty("user.country"),
                USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("user.address"), USERINFO_PROPERTIES.getProperty("user.city"),
                USERINFO_PROPERTIES.getProperty("user.postcode"), USERINFO_PROPERTIES.getProperty("user.testPhone"));
        CheckoutPagePay paymentPage = deliveryOption.submitDeliveryOption();
        CheckoutPageConfirm orderConfirmationPage = paymentPage.selectPaymentMethod(USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("card.testNumber"),
                USERINFO_PROPERTIES.getProperty("card.expirationMonth"), USERINFO_PROPERTIES.getProperty("card.expirationYear"));
        orderConfirmationPage.submitPayment();

        //Check successful title about placed order on the home page
        Assert.assertEquals(USERINFO_PROPERTIES.getProperty("title.successfulOrder"), orderConfirmationPage.getTitle());
    }*/

}

