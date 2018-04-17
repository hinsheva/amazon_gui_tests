package com.amazon.config;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHolder {

    static final Properties WEBDRIVER_PROPERTIES = readPropertiesFromFile("/config.properties");
    public static final Properties USERINFO_PROPERTIES = readPropertiesFromFile("/testData.properties");
    public static final Properties WEBAPPDATA_PROPERTIES = readPropertiesFromFile("/webAppData.properties");

    //Read driver, userInfo and webApp properties from the files that are stored in 'resources' package
    private static Properties readPropertiesFromFile(String fileName) {
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = PropertiesHolder.class.getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
