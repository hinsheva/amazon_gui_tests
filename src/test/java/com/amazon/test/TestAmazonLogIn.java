package com.amazon.test;

import com.amazon.config.TestInitializer;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static com.amazon.test.TestHelper.login;
import static org.junit.Assert.assertEquals;

class TestAmazonLogIn extends TestInitializer {

    @Test
    void testLogin() {
        String authorizedUserTitle = "Hello, " + getUserInfoProperty("user.name") + "\nYour Account";
        login(getHomePage());
        //Check user name on the home page after login
        assertEquals(authorizedUserTitle, getHomePage().getTitle());
    }
}
