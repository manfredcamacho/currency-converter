package org.example.currencyconverter.record;

public record  ExchangeRateRecord(
        String result,
        int time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        ConversionRatesRecord conversion_rates
){}