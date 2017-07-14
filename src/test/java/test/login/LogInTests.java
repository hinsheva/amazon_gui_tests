package test.login;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by HINSHEVA on 7/13/2017.
 */
public class LogInTests {
    private static WebDriver driver;



    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://reports.spd-ukraine.com/login");
        WebDriver.Options manage = driver.manage();
        manage.window().setSize(new Dimension(1920,1080));
    }


    @Test
    public void firstTest() throws InterruptedException {
        WebElement loginField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        loginField.clear();
        loginField.sendKeys("h.insheva@spd-ukraine.com");
        passwordField.clear();
        passwordField.sendKeys("London02");
        WebElement singIn = driver.findElement(By.cssSelector("*[class^='buttonText text-center']"));
        singIn.click();


        WebDriverWait waitModal;
        waitModal = new WebDriverWait(driver, 1000);
        waitModal.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal-dialog button")));

        WebElement modalClose = driver.findElement(By.cssSelector(".modal-dialog button"));
        modalClose.click();

        WebDriverWait waitElement;
        waitElement = new WebDriverWait(driver, 100000000);
        waitElement.until(ExpectedConditions.elementToBeClickable(By.linkText("Calendar"))).click();
        String urlCalendar = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/calendar", urlCalendar);


        WebElement tabStatistics = driver.findElement(By.linkText("Statistics"));
        tabStatistics.click();
        String urlStatistics = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/statistics", urlStatistics);

        WebElement tabUsers = driver.findElement(By.linkText("Users"));
        tabUsers.click();
        String urlUsers = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/users", urlUsers);

        WebElement tabLibrary = driver.findElement(By.linkText("Library"));
        tabLibrary.click();
        String urlLibrary = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/library", urlLibrary);

        WebElement tabContacts = driver.findElement(By.linkText("Contacts"));
        tabContacts.click();
        String urlContacts = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/contacts", urlContacts);


        WebElement userLogOut = driver.findElement(By.cssSelector("#bs-navbar-collapse-1 > ul.nav.navbar-nav.navbar-right > li > a"));
        userLogOut.click();


        WebElement logOut = driver.findElement(By.linkText("LogOut"));
        logOut.click();
        String urlLogIn = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/login", urlLogIn);


    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
