package com.kot.notificatorok.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingsProvider {

    @Value("${binance.api.key}")
    private String apiKey;

    @Value("${binance.api.secretKey}")
    private String secretKey;


    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
