package org.example.currencyconverter.record;

import org.example.currencyconverter.model.Currency;

import java.util.Map;

public record  ExchangeRateRecord(
    String result,
    int time_next_update_unix,
    String base_code,
    Map<Currency, Double> conversion_rates
){}