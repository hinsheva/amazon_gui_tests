package com.amazon.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebEventListener extends AbstractWebDriverEventListener {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        logger.info("Navigated to:'" + url + "'");
    }


    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("Clicked on: " + element.toString());
    }

    public void beforeNavigateBack(WebDriver driver) {
        logger.info("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        logger.info("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        logger.info("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        logger.info("Navigated forward to next page");
    }

    public void onException(Throwable error, WebDriver driver) {
        logger.info("Exception occured: " + error);
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Found Element By : " + by.toString());
    }

}
