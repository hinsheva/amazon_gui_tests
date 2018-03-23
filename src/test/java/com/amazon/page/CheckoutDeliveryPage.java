package com.amazon.page;

import org.openqa.selenium.By;

public class CheckoutDeliveryPage extends BasePage {

    private By countryDropDownLocator = By.id("enterAddressCountryCode");
    private By fullNameInputLocator = By.id("enterAddressFullName");
    private By phoneNumberInputLocator = By.id("enterAddressPhoneNumber");
    private By postcodeInputLocator = By.id("enterAddressPostalCode");
    private By addressInputLocator = By.id("enterAddressAddressLine1");
    private By cityInputLocator = By.id("enterAddressCity");
    private By submitDeliveryAddressButtonLocator = By.xpath("//input[@name='shipToThisAddress']");

    //Submit Delivery Info and proceed to Delivery Options Page
    public CheckoutDeliveryOptionsPage fillAndSubmitDeliveryInfo(String countryName, String fullName, String address, String city, String postcode, String phoneNumber) {
        fillDeliveryInfo(countryName, fullName, address, city, postcode, phoneNumber);
        submitDeliveryInfo();
        return new CheckoutDeliveryOptionsPage();
    }

    //Fill all required user's delivery info
    private void fillDeliveryInfo(String countryName, String fullName, String address, String city, String postcode, String phoneNumber) {
        //Select user's country form the delivery address drop-down
        clickElement(countryDropDownLocator);
        selectDropDownValue(countryDropDownLocator, countryName);
        inputData(fullNameInputLocator, fullName);
        inputData(addressInputLocator, address);
        inputData(cityInputLocator, city);
        inputData(postcodeInputLocator, postcode);
        inputData(phoneNumberInputLocator, phoneNumber);
    }

    //Press the button to confirm Delivery Address
    public void submitDeliveryInfo() {
        clickElement(submitDeliveryAddressButtonLocator);
    }
}
