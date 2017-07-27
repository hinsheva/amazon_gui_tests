package test.smoke.test;

import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HINSHEVA on 7/17/2017.
 */
public class WebAppSmoke {
    private static WebDriver driver;
    private static SmokeTestMethods element;

    @Before
    public void setUp() {
        if (element == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.navigate().to("https://reports.spd-ukraine.com/login");
            WebDriver.Options manage = driver.manage();
            manage.window().setSize(new Dimension(1920, 1080));

            element = new SmokeTestMethods(driver);

            element.logIn("h.insheva@spd-ukraine.com", "London02", "*[class^='buttonText text-center']");
            element.closeModal(".modal-dialog button");
        }
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


    @Test
    public void testLogIn() {
        // Logic in setUp
    }

    @Test
    public void testTabs(){
        element.clickElement("Calendar", "https://reports.spd-ukraine.com/calendar");
        element.clickElement("Statistics", "https://reports.spd-ukraine.com/statistics");
        element.clickElement("Users", "https://reports.spd-ukraine.com/users");
        element.clickElement("Library", "https://reports.spd-ukraine.com/library");
        element.clickElement("Contacts", "https://reports.spd-ukraine.com/contacts");
    }

    @Test
    public void testLogOut(){
        element.logOut("#bs-navbar-collapse-1 > ul.nav.navbar-nav.navbar-right > li > a", "LogOut", "https://reports.spd-ukraine.com/login");
    }
}


