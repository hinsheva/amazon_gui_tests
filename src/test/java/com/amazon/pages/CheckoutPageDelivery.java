package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageDelivery {
    private WebDriver driver;

    CheckoutPageDelivery(WebDriver driver) {
        this.driver = driver;
    }

    private By countryDropDownLocator = By.xpath("//*[@id=\"enterAddressCountryCode\"]");
    private By fullNameInputLocator = By.xpath("//*[@id=\"enterAddressFullName\"]");
    private By phoneNumberInputLocator = By.xpath("//*[@id=\"enterAddressPhoneNumber\"]");
    private By postcodeInputLocator = By.xpath("//*[@id=\"enterAddressPostalCode\"]");
    private By addressInputLocator = By.xpath("//*[@id=\"enterAddressAddressLine1\"]");
    private By cityInputLocator = By.xpath("//*[@id=\"enterAddressCity\"]");
    private By submitDeliveryAddressButtonLocator = By.xpath("//input[@name='shipToThisAddress']");
    private By countriesListLocator = By.id("enterAddressCountryCode");

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

    private void selectDeliveryCountry(String countryName) {
        driver.findElement(countryDropDownLocator).click();
        Select countryOption = new Select(driver.findElement(countriesListLocator));
        countryOption.selectByVisibleText(countryName);
    }

    private void typeFullName(String fullName){
        WebElement fullNameInput = driver.findElement(fullNameInputLocator);
        fullNameInput.click();
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
    }

    private void typeAddress(String address){
        WebElement fullNameInput = driver.findElement(addressInputLocator);
        fullNameInput.click();
        fullNameInput.clear();
        fullNameInput.sendKeys(address);
    }

    private void typeCity(String city){
        WebElement fullNameInput = driver.findElement(cityInputLocator);
        fullNameInput.click();
        fullNameInput.clear();
        fullNameInput.sendKeys(city);
    }

    private void typePostcode(String postcode){
        WebElement fullNameInput = driver.findElement(postcodeInputLocator);
        fullNameInput.click();
        fullNameInput.clear();
        fullNameInput.sendKeys(postcode);
    }

    private void typePhoneNumber(String phoneNumber){
        WebElement fullNameInput = driver.findElement(phoneNumberInputLocator);
        fullNameInput.click();
        fullNameInput.clear();
        fullNameInput.sendKeys(phoneNumber);
    }

    private void submitDeliveryAddress(){
        driver.findElement(submitDeliveryAddressButtonLocator).click();
    }
}
