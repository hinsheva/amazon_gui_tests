package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageDelivery {
    private WebDriver driver;

    CheckoutPageDelivery(WebDriver driver) {
        this.driver = driver;
    }

    private By countryDropDownLocator = By.id("enterAddressCountryCode");
    private By fullNameInputLocator = By.id("enterAddressFullName");
    private By phoneNumberInputLocator = By.id("enterAddressPhoneNumber");
    private By postcodeInputLocator = By.id("enterAddressPostalCode");
    private By addressInputLocator = By.id("enterAddressAddressLine1");
    private By cityInputLocator = By.id("enterAddressCity");
    private By submitDeliveryAddressButtonLocator = By.xpath("//input[@name='shipToThisAddress']");
    private By countriesListLocator = By.id("enterAddressCountryCode");

    //Submit Delivery Info and proceed to Delivery Options Page
    public CheckoutPageDeliveryOptions fillAndSubmitDeliveryInfo(String countryName, String fullName, String address, String city, String postcode, String phoneNumber) {
        fillDeliveryInfo(countryName, fullName, address, city, postcode, phoneNumber);
        submitDeliveryInfo();
        return new CheckoutPageDeliveryOptions(driver);
    }


    //Fill all required user's delivery info
    private void fillDeliveryInfo(String countryName, String fullName, String address, String city, String postcode, String phoneNumber){
        //Select user's country form the delivery address drop-down
        driver.findElement(countryDropDownLocator).click();
        Select countryOption = new Select(driver.findElement(countriesListLocator));
        countryOption.selectByVisibleText(countryName);

        driver.findElement(fullNameInputLocator).sendKeys(fullName);

        driver.findElement(addressInputLocator).sendKeys(address);

        driver.findElement(cityInputLocator).sendKeys(city);

        driver.findElement(postcodeInputLocator).sendKeys(postcode);

        driver.findElement(phoneNumberInputLocator).sendKeys(phoneNumber);
    }

    //Press the button to confirm Delivery Address
    public void submitDeliveryInfo() {
        driver.findElement(submitDeliveryAddressButtonLocator).click();
    }
}
