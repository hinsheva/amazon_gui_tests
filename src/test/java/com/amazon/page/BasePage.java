package com.amazon.page;

import com.amazon.config.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.amazon.config.PropertiesHolder.USERINFO_PROPERTIES;

public abstract class BasePage extends Initializer{

    //Methods used in Pages
    static void clickElement(By locator) {
        getElement(locator).click();
    }

    static void inputData(By locator, String inputData) {
        getElement(locator).sendKeys(inputData);
    }

    static String getElementText(By locator) {
        return getElement(locator).getText();
    }


    static WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    static void waitUntilElementDisappears(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    static void selectDropDownValue(By locator, String text) {
        Select value = new Select(getElement(locator));
        value.selectByVisibleText(text);
    }

    static void setJsDropDownOption(By locator, String optionText) {
        WebElement dropDown = getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'display: block;')", dropDown);
        dropDown.sendKeys(optionText);
    }

    //Methods used in Tests:
    public void login() {
        String email = USERINFO_PROPERTIES.getProperty("user.testEmail");
        String password = USERINFO_PROPERTIES.getProperty("user.testPassword");
        String notAuthorizedUserTitle = "Hello. Sign in\n" + "Your Account";

        if (getHomePage().getTitle().equals(notAuthorizedUserTitle)) {
            getHomePage().clickSignInLink()
                    .logIn(email, password);
        }
    }

    public CartPage addItemToCart() {
        String itemName = USERINFO_PROPERTIES.getProperty("item.name");

        getHomePage().searchForItem(itemName)
                .selectItem()
                .addItemToCart();
        return new CartPage();
    }

    public CheckoutDeliveryOptionsPage submitDeliveryInfoWithItemInCart() {
        String country = USERINFO_PROPERTIES.getProperty("user.country");
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String address = USERINFO_PROPERTIES.getProperty("user.address");
        String city = USERINFO_PROPERTIES.getProperty("user.city");
        String postcode = USERINFO_PROPERTIES.getProperty("user.postcode");
        String phone = USERINFO_PROPERTIES.getProperty("user.testPhone");

        addItemToCart()
                .proceedToCheckout()
                .fillAndSubmitDeliveryInfo(country, userName, address, city, postcode, phone);
        return new CheckoutDeliveryOptionsPage();
    }

    public HomePage placeOrder() {
        String userName = USERINFO_PROPERTIES.getProperty("user.name");
        String cardNumber = USERINFO_PROPERTIES.getProperty("card.testNumber");
        String cardExpMonth = USERINFO_PROPERTIES.getProperty("card.expirationMonth");
        String cardExpYear = USERINFO_PROPERTIES.getProperty("card.expirationYear");

        submitDeliveryInfoWithItemInCart()
                .submitDeliveryOption()
                .submitPaymentMethod(userName, cardNumber, cardExpMonth, cardExpYear)
                .submitPayment();
        return new HomePage();
    }
}

