package com.amazon.suits;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({TestAmazonLogIn.class, TestAmazonSearchItem.class})
@SelectPackages("com.amazon.test")
public class TestSuiteSmoke {
}
