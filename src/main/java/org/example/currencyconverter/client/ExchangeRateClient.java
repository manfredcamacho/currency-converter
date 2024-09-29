package org.example.currencyconverter.client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.currencyconverter.model.Currency;
import org.example.currencyconverter.record.ExchangeRateRecord;
import org.example.currencyconverter.service.ConfigService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ExchangeRateClient {
    private static ExchangeRateClient INSTANCE;
    private final String baseUrl;
    private final String apiToken;

    private ExchangeRateClient() {
        ConfigService config = ConfigService.getInstance();
        this.apiToken = config.getProperty("exchange-rate-api.token");
        this.baseUrl = config.getProperty("exchange-rate-api.base-url");
    }

    public static ExchangeRateClient getInstance(){
        if(INSTANCE == null) INSTANCE = new ExchangeRateClient();

        return INSTANCE;
    }

    public ExchangeRateRecord getExchangeRate(Currency currency) throws RuntimeException {
        try {
            String requestUrl = baseUrl + apiToken + "/latest/" + currency;

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

            return gson.fromJson(response.body(), ExchangeRateRecord.class);

        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred while retrieving exchange rate");
            throw new RuntimeException(e);
        }
    }
}