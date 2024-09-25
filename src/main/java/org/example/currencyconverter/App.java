package org.example.currencyconverter;

import org.example.currencyconverter.client.ExchangeRateClient;

import java.io.IOException;
import java.util.Currency;
import java.util.Properties;

public class App
{

    public static void main( String[] args )
    {
        Properties prop = new Properties();
        String exchangeRateToken;
        String exchangeRateBaseUrl;

        try {
            prop.load(App.class.getClassLoader().getResourceAsStream("config.properties"));
            exchangeRateToken = prop.getProperty("exchange-rate-api.token");
            exchangeRateBaseUrl = prop.getProperty("exchange-rate-api.base-url");
        } catch (IOException | RuntimeException e) {
            System.out.println("No properties found");
            throw new RuntimeException(e);
        }

        ExchangeRateClient exchangeRateClient = new ExchangeRateClient(exchangeRateBaseUrl, exchangeRateToken);
        exchangeRateClient.getExchangeRate(Currency.getInstance("USD"), Currency.getInstance("ARS"));
    }
}
