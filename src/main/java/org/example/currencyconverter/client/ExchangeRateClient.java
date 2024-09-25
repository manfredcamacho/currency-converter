package org.example.currencyconverter.client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.currencyconverter.record.ExchangeRateRecord;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Currency;

public class ExchangeRateClient {
    private String baseUrl;
    private String apiToken;


    public ExchangeRateClient(String baseUrl, String apiToken) {
        this.baseUrl = baseUrl;
        this.apiToken = apiToken;
    }

    public ExchangeRateRecord getExchangeRate(Currency fromCurrency, Currency toCurrency) {
        try {
            String requestUrl = baseUrl + apiToken + "/latest/" + fromCurrency;

            HttpResponse<String> response;
            try (HttpClient client = HttpClient.newHttpClient()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(requestUrl))
                        .build();

                response = client
                        .send(request, BodyHandlers.ofString());
            }

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();

            ExchangeRateRecord record = gson.fromJson(response.body(), ExchangeRateRecord.class);

            System.out.println(response.body());

            System.out.println("***************************");


            System.out.println(record.toString());

        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred while retrieving exchange rate");
            System.out.println(e.getMessage());
        }

        return null;
    }
}