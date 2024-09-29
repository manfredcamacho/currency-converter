package org.example.currencyconverter.service;

import org.example.currencyconverter.client.ExchangeRateClient;
import org.example.currencyconverter.model.Currency;
import org.example.currencyconverter.model.ExchangeRate;
import java.util.Map;

public class ExchangeRateService {
    private static ExchangeRateService INSTANCE;
    private ExchangeRateClient exchangeRateClient;
    private Map<Currency, ExchangeRate> exchangeRates;

    private ExchangeRateService(){
        this.exchangeRateClient = ExchangeRateClient.getInstance();
    }

    public static ExchangeRateService getInstance(){
        if(INSTANCE == null) INSTANCE = new ExchangeRateService();

        return INSTANCE;
    }

    public void loadExchangeRates() {}

    public double getExchangeRate(Currency from, Currency to) {
        return exchangeRateClient.getExchangeRate(from).conversion_rates().get(to);
    }

    public double convertCurrency(Currency from, Currency to, double amount) {
        double rate =  getExchangeRate(from, to);
        return amount * rate;
    }

    public boolean shouldUpdateExchangeRate(ExchangeRate exchangeRate) {
        long currentTimeUnix = System.currentTimeMillis() / 1000;
        return currentTimeUnix >= exchangeRate.getTimeNextUpdate();
    }
}