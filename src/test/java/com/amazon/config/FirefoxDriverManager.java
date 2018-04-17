package com.amazon.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        //SetUp WebDriver Properties
        String driverName = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("firefoxDriver.name");
        String driverPath = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("firefoxDriver.path");
        String websiteUrl = PropertiesHolder.WEBAPPDATA_PROPERTIES.getProperty("web.url");

        //SetUP Driver and connect EventListener
        System.setProperty(driverName, driverPath);
        driver = new EventFiringWebDriver(new FirefoxDriver());
        WebEventListener eventListener  = new WebEventListener();
        ((EventFiringWebDriver) driver).register(eventListener);
        //Open WebApp
        driver.navigate().to(websiteUrl);
        // Maximize Browser Window
        WebDriver.Options manage = driver.manage();
        manage.window().maximize();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
