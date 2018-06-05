package com.amazon.config;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    DriverManager() {
    }

    public WebDriver driver;
    public abstract void createDriver();

    WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
