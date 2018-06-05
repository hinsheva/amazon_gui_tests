package com.amazon.test;

import com.amazon.config.TestInitializer;
import com.amazon.pageObjects.CreateAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.amazon.config.PropertiesHolder.getUserInfoProperty;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestAmazonAccountCreation extends TestInitializer {
    private CreateAccountPage createAccountPage;

    @BeforeEach
    void beforeMethod() {
        super.setUpBeforeTestMethod();
        createAccountPage = getHomePage()
                .clickSignInLink()
                .clickCreateYourAmazonAccountButton();
    }

    @Test
    void testAccountCreation() {
        createAccountPage.createNewAccount(getUserInfoProperty("user.name"), getUserInfoProperty("user.testEmail"),
                getUserInfoProperty("user.testPassword"));

        //Check user name on the home page after account creation and auto-login
        assertTrue(getHomePage().getTitle().contains(getUserInfoProperty("user.name")));
    }
}