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

    //Fill all required user' data to submit Delivery Info and proceed to Delivery Options Page
    public CheckoutPageDeliveryOptions fillAndSubmitDeliveryInfo(String countryName, String fullName, String address, String city, String postcode, String phoneNumber) {
        selectDeliveryCountry(countryName);
        typeFullName(fullName);
        typeAddress(address);
        typeCity(city);
        typePostcode(postcode);
        typePhoneNumber(phoneNumber);
        submitDeliveryAddress();
        return new CheckoutPageDeliveryOptions(driver);
    }

    //Select user's country form the delivery address drop-down
    private void selectDeliveryCountry(String countryName) {
        driver.findElement(countryDropDownLocator).click();
        Select countryOption = new Select(driver.findElement(countriesListLocator));
        countryOption.selectByVisibleText(countryName);
    }

    //Fill 'full name' field with user's full name
    private void typeFullName(String fullName) {
        driver.findElement(fullNameInputLocator).sendKeys(fullName);
    }

    //Fill 'address' field with user's address info
    private void typeAddress(String address) {
        driver.findElement(addressInputLocator).sendKeys(address);
    }

    //Fill 'city' field with user's city info
    private void typeCity(String city) {
        driver.findElement(cityInputLocator).sendKeys(city);
    }

    //Fill 'postcode' field with user's postcode info
    private void typePostcode(String postcode) {
        driver.findElement(postcodeInputLocator).sendKeys(postcode);
    }

    //Fill 'phone number' field with user's phone number info
    private void typePhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInputLocator).sendKeys(phoneNumber);
    }

    //Press the button to confirm Delivery Address
    private void submitDeliveryAddress() {
        driver.findElement(submitDeliveryAddressButtonLocator).click();
    }
}
