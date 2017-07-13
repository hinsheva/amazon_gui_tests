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

import java.util.concurrent.TimeUnit;


/**
 * Created by HINSHEVA on 7/13/2017.
 */
public class LogInTests {
    private static WebDriver driver;
    private WebDriver mainPage;


    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://reports.spd-ukraine.com/login");
        WebDriver.Options manage = driver.manage();
        manage.window().setSize(new Dimension(1920,1080));
        manage.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        //WebElement modalClose = driver.findElement(By.cssSelector("#bodyContainer"));

        Thread.sleep(300);

        WebElement modalClose = driver.findElement(By.cssSelector(".modal-dialog button"));
        modalClose.click();
        Thread.sleep(800);


        /*WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("trackTime")));*/

        WebElement tabCalendar = driver.findElement(By.linkText("Calendar"));
        tabCalendar.click();
        String urlCalendar = driver.getCurrentUrl();
        String urlAfterLoginCalendar = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/calendar", urlAfterLoginCalendar);

        WebElement tabStatistics = driver.findElement(By.linkText("Statistics"));
        // Alternative variant: WebElement tabSite = driver.findElement(By.cssSelector("#bs-navbar-collapse-1 > ul:nth-child(1) > li:nth-child(3) a"));
        tabStatistics.click();
        String urlStatistics = driver.getCurrentUrl();
        String urlAfterLoginStatistics = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/statistics", urlAfterLoginStatistics);

        WebElement tabUsers = driver.findElement(By.linkText("Users"));
        tabUsers.click();
        String urlUsers = driver.getCurrentUrl();
        String urlAfterLoginUsers = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/users", urlAfterLoginUsers);

        WebElement tabLibrary = driver.findElement(By.linkText("Library"));
        tabLibrary.click();
        String urlLibrary = driver.getCurrentUrl();
        String urlAfterLoginLibrary = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/library", urlAfterLoginLibrary);

        WebElement tabContacts = driver.findElement(By.linkText("Contacts"));
        tabContacts.click();
        String urlContacts = driver.getCurrentUrl();
        String urlAfterLoginContacts = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/contacts", urlAfterLoginContacts);

        Thread.sleep(300);

        //WebElement userLogOut = driver.findElement(By.linkText("Helen"));
        WebElement userLogOut = driver.findElement(By.cssSelector("#bs-navbar-collapse-1 > ul.nav.navbar-nav.navbar-right > li > a"));
        userLogOut.click();
        Thread.sleep(300);
        WebElement logOut = driver.findElement(By.linkText("LogOut"));
        logOut.click();
        String urlLogOut = driver.getCurrentUrl();
        String urlAfterLogOut = driver.getCurrentUrl();
        Assert.assertEquals("https://reports.spd-ukraine.com/login", urlAfterLogOut);


    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
