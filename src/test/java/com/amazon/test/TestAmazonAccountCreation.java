package com.amazon.test;

import com.amazon.page.BasePage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestAmazonAccountCreation extends BasePage{

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