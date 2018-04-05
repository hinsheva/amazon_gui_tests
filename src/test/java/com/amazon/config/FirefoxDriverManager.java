package com.amazon.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        //SetUp WebDriver Properties
        String driverName = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("firefoxDriver.name");
        String driverPath = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("firefoxDriver.path");
        String websiteUrl = PropertiesHolder.WEBAPPDATA_PROPERTIES.getProperty("web.url");

        //SetUP Driver
        System.setProperty(driverName, driverPath);
        driver = new FirefoxDriver();
        //Open WebApp
        driver.navigate().to(websiteUrl);
        // Maximize Browser Window
        WebDriver.Options manage = driver.manage();
        manage.window().maximize();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
