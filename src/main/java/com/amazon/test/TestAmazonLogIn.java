package com.amazon.test;

import com.amazon.config.TestInitializer;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static com.amazon.test.TestHelper.login;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestAmazonLogIn extends TestInitializer {

    @Test
    void testLogin() {
        login(getHomePage());

        //Check user name on the home page after login
        assertTrue(getHomePage().getTitle().contains(getUserInfoProperty("user.name")));
    }
}
