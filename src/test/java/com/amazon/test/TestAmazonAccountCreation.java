package com.amazon.test;

import com.amazon.config.TestInitializer;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestAmazonAccountCreation extends TestInitializer {

    @Test
    void testAccountCreation() {
        String authorizedUserTitle = "Hello, " + getUserInfoProperty("user.name") + "\nYour Account";
        getHomePage().clickSignInLink()
                .clickCreateYourAmazonAccountButton()
                .createNewAccount(getUserInfoProperty("user.name"), getUserInfoProperty("user.testEmail"), getUserInfoProperty("user.testPassword"));
        //Check user name on the home page after account creation and auto-login
        assertEquals(authorizedUserTitle, getHomePage().getTitle());
    }
}