package com.amazon.test;

import com.amazon.page.BasePage;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;
import static org.junit.Assert.assertEquals;

public class TestAmazonLogIn extends BasePage {

    @Test
    void testLogin() {
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String authorizedUserTitle = "Hello, " + userName + "\nYour Account";
        login();
        //Check user name on the home page after login
        assertEquals(authorizedUserTitle, getHomePage().getTitle());
    }
}
