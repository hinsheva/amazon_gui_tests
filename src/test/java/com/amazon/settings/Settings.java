package com.amazon.settings;

import com.amazon.pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Settings {
    protected static WebDriver driver;
    private static HomePage homePage;
    protected String userEmail = "h.insheva@spd-ukraine.com";
    protected String userPassword = "password911";
    protected String userName = "Helen";
    protected String userCountry = "United Kingdom";
    protected String userPhoneNumber = "+380975460525";
    protected String userPostcode = "NW1 8AF";
    protected String userAddress = "66 WEST YARD CAMDEN LOCK PLACE";
    protected String userCity = "London";
    protected String itemName = "Silver Bay: A Novel by Jojo Moyes (2014-08-26)";
    protected String successfulTitleForCartAddedItem = "Added to Basket";
    protected String userCardNumber = "5363542305720832";
    protected String cardExpirationMonth = "08";
    protected String cardExpirationYear = "2019";
    protected String successTitle = "Thank you, your order has been placed.";


    @BeforeAll
    static void setUp() {
        if (homePage == null) {
            setBrowser();
            openWebApp();
            maximizeBrowserWindow();

            homePage = new HomePage(driver);
        }
    }

    private static void setBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    private static void openWebApp() {
        driver.navigate().to("https://www.amazon.co.uk/");
    }

    private static void maximizeBrowserWindow() {
        WebDriver.Options manage = driver.manage();
        manage.window().maximize();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }


}
