package com.amazon;

import com.amazon.pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    protected static WebDriver driver;
    private static HomePage homePage;
    private static Properties WEBDRIVER_PROPERTIES;
    public static Properties USERINFO_PROPERTIES;

    static {
        WEBDRIVER_PROPERTIES = readPropertiesFromFile("/config.properties");
        USERINFO_PROPERTIES = readPropertiesFromFile("testData.properties");
    }

    //Read webdriver and userInfo properties from the files that are stored in 'resources' package
    static Properties readPropertiesFromFile(String fileName) {
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            Class clazz = Base.class;
            inputStream = clazz.getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void clickElement(By locator){
        getElement(locator).click();
    }

    public static void inputData(By locator, String inputData){
        getElement(locator).sendKeys(inputData);
    }

    public static String getElementText(By locator){
        return getElement(locator).getText();
    }

    public static WebElement getElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    public static void waitUntilElementDisappears(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void selectDropDownValue(By locator, String text){
        Select value = new Select(getElement(locator));
        value.selectByVisibleText(text);
    }

    public static void setJsDropDownOption(By locator, String optionText){
        WebElement dropDown = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", dropDown);
        dropDown.sendKeys(optionText);
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
        //driver.close();
    }
}
