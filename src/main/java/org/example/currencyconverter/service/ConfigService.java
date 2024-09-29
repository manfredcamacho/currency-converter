package org.example.currencyconverter.service;

import org.example.currencyconverter.App;

import java.io.IOException;
import java.util.Properties;

public class ConfigService {
    private static ConfigService INSTANCE;
    private Properties properties;

    private ConfigService(){
        properties = new Properties();
        try {
            properties.load(App.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException | RuntimeException e) {
            System.out.println("No properties file found");
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public static ConfigService getInstance(){
        if(INSTANCE == null) INSTANCE = new ConfigService();

        return INSTANCE;
    }
}
