package com.amazon.test;

import com.amazon.config.TestInitializer;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestAmazonAccountCreation extends TestInitializer {

    @Test
    void testAccountCreation() {
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String email = USERINFO_PROPERTIES.getProperty("user.testEmail");
        String password = USERINFO_PROPERTIES.getProperty("user.testPassword");
        String authorizedUserTitle = "Hello, " + userName + "\nYour Account";
        getHomePage().clickSignInLink()
                .clickCreateYourAmazonAccountButton()
                .createNewAccount(userName, email, password);
        //Check user name on the home page after account creation and auto-login
        assertEquals(authorizedUserTitle, getHomePage().getTitle());
    }
}