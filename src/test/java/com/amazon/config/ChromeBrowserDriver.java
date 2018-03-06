package com.amazon.config;

import com.amazon.page.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class ChromeBrowserDriver {
    //Set web driver(Chrome) and navigate to webApp(Amazon.com)
    public static WebDriver driver;
    public static HomePage homePage;

    @BeforeAll
    static void setUp() throws Exception {
        //SetUp WebDriver Properties
        String driverName = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("driver.name");
        String driverPath = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("driver.path");
        String websiteUrl = PropertiesHolder.WEBAPPDATA_PROPERTIES.getProperty("web.url");

        if (homePage == null) {
            //SetUP Driver
            System.setProperty(driverName, driverPath);
            driver = new org.openqa.selenium.chrome.ChromeDriver();
            //Open WebApp
            driver.navigate().to(websiteUrl);
            // Maximize Browser Window
            WebDriver.Options manage = driver.manage();
            manage.window().maximize();
            manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            homePage = new HomePage();
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }
}
