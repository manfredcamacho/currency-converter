package org.example.currencyconverter.record;

import com.google.gson.annotations.SerializedName;

public record ConversionRatesRecord(
        @SerializedName("USD") double usd,
        @SerializedName("ARS") double ars,
        @SerializedName("MXN") double mxn,
        @SerializedName("COP") double cop
){}
