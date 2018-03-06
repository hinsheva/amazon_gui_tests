package com.amazon.test;

import com.amazon.config.ChromeBrowserDriver;
import com.amazon.page.SignInPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;

class TestAmazonLogIn extends ChromeBrowserDriver {

    @Test
    void testLogIn() {
        SignInPage signInPage = homePage.clickSignInLink();
        signInPage.logIn(USERINFO_PROPERTIES.getProperty("user.testEmail"), USERINFO_PROPERTIES.getProperty("user.testPassword"));
        //Check user name on the home page after login
        Assert.assertEquals("Hello, " + USERINFO_PROPERTIES.getProperty("user.name") + "\nYour Account", homePage.getTitle());
    }
}