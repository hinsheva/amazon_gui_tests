package com.amazon.test;

import com.amazon.config.ChromeBrowserDriver;
import com.amazon.page.CreateAccountPage;
import com.amazon.page.SignInPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;

class TestAmazonAccountCreation extends ChromeBrowserDriver {

    @Test
    void testNewAccountCreation() {
        SignInPage signInPage = homePage.clickSignInLink();
        CreateAccountPage createAccountPage = signInPage.clickCreateYourAmazonAccountButton();
        createAccountPage.createNewAccount(USERINFO_PROPERTIES.getProperty("user.name"), USERINFO_PROPERTIES.getProperty("user.testEmail"),
                USERINFO_PROPERTIES.getProperty("user.testPassword"));
        //Check user name on the home page after account creation
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());
    }
}