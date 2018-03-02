package com.amazon.tests;

import com.amazon.Base;
import com.amazon.pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestAmazonAccountCreation extends Base {

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
}

