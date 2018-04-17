package com.amazon.config;

import com.amazon.page.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class TestInitializer {
    //This Class setUp web driver(Chrome), navigate to webApp(Amazon.com) and initialize the initial webApp page(Home)
    private static DriverManager driverManager;
    private HomePage homePage;

    protected WebDriver getDriver(){
        return driverManager.driver;
    }

    protected HomePage getHomePage() {
        return homePage;
    }

    @BeforeAll
    public static void setUpDriverManager() {
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    }

    @BeforeEach
    public void setUpHomePage() {
        homePage = new HomePage(driverManager.getDriver());
    }

    @AfterAll
    public static void tearDown() {
        driverManager.getDriver().close();
    }
}