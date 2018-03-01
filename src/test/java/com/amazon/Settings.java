package com.amazon;

import com.amazon.pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Settings {
    protected static WebDriver driver;
    private static HomePage homePage;
    private static Properties WEBDRIVER_PROPERTIES;
    public static Properties USERINFO_PROPERTIES;

    static {
        WEBDRIVER_PROPERTIES = readPropertiesFromFile("/config.properties");
        USERINFO_PROPERTIES = readPropertiesFromFile("testData.properties");
    }

    //Read webdriver and userinfo properties from the files that are stored in 'resources' package
    static Properties readPropertiesFromFile(String fileName) {
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            Class clazz = Settings.class;
            inputStream = clazz.getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    //Set web driver(Chrome) and navigate to webApp(Amazon.com)
    @BeforeAll
    static void setUp() throws Exception {
        //SetUp Properties
        String driverName = WEBDRIVER_PROPERTIES.getProperty("driver.name");
        String driverPath = WEBDRIVER_PROPERTIES.getProperty("driver.path");
        String url = WEBDRIVER_PROPERTIES.getProperty("web.url");

        if (homePage == null) {
            //SetUP Driver
            System.setProperty(driverName, driverPath);
            driver = new ChromeDriver();
            //Open WebApp
            driver.navigate().to(url);
            // Maximize Browser Window
            WebDriver.Options manage = driver.manage();
            manage.window().maximize();
            manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            homePage = new HomePage(driver);
        }
    }

    @AfterAll
    public static void tearDown() {
    }
}
