package com.amazon.config;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHolder {

    public static Properties WEBDRIVER_PROPERTIES;
    public static Properties USERINFO_PROPERTIES;
    public static Properties WEBAPPDATA_PROPERTIES;

    static {
        WEBDRIVER_PROPERTIES = readPropertiesFromFile("/config.properties");
        USERINFO_PROPERTIES = readPropertiesFromFile("/testData.properties");
        WEBAPPDATA_PROPERTIES = readPropertiesFromFile("/webAppData.properties");
    }

    //Read webDriver, userInfo and webApp properties from the files that are stored in 'resources' package
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
