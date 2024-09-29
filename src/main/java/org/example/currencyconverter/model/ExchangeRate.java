package org.example.currencyconverter.model;

import org.example.currencyconverter.record.ExchangeRateRecord;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
    private final int timeNextUpdateUnix;
    private final String base;
    private final Map<Currency, Double> exchangeRate;

    public ExchangeRate(ExchangeRateRecord exchangeRateRecord) {
        this.timeNextUpdateUnix = exchangeRateRecord.time_next_update_unix();
        this.base = exchangeRateRecord.base_code();
        this.exchangeRate = new HashMap<>(exchangeRateRecord.conversion_rates());
    }

    public int getTimeNextUpdate() {
        return timeNextUpdateUnix;
    }

    public String getBase() {
        return base;
    }

    public Map<Currency, Double> getExchangeRate() {
        return exchangeRate;
    }
}
