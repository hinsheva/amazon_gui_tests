package com.amazon.config;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHolder {

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

    static final String getWebDriverProperty(String key) {
        return readPropertiesFromFile("/config.properties").getProperty(key);
    }

    public static final String getUserInfoProperty(String key) {
        return readPropertiesFromFile("/testData.properties").getProperty(key);
    }

    public static final String getWebAppProperty(String key) {
        return readPropertiesFromFile("/webAppData.properties").getProperty(key);
    }
}

