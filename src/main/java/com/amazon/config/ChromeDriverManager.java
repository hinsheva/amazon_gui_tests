package com.amazon.config;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        //SetUp WebDriver Properties
        String driverName = PropertiesHolder.getWebDriverProperty("chromeDriver.name");
        String driverPath = PropertiesHolder.getWebDriverProperty("chromeDriver.path");
        String websiteUrl = PropertiesHolder.getWebAppProperty("web.url");

        //SetUP Driver
        System.setProperty(driverName, driverPath);
        driver = new org.openqa.selenium.chrome.ChromeDriver();

        //Open WebApp
        driver.navigate().to(websiteUrl);
        // Maximize Browser Window
        WebDriver.Options manage = driver.manage();
        manage.window().maximize();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
