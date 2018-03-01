package com.amazon.tests;

import com.amazon.Settings;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestAmazonLogIn extends Settings {

    @Test
    void testLogIn() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"), USERINFO_PROPERTIES.getProperty("user.testPassword"));
        //Check user name on the home page after login
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());
    }
}

