package com.kot.notificatorok.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SettingsProvider {

    @Value("${binance.api.key}")
    private String apiKey;

    @Value("${binance.api.secretKey}")
    private String secretKey;

    @Value("${binance.multiply}")
    private BigDecimal multiply;

    public String getApiKey() {
        return apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public BigDecimal getMultiply() {
        return multiply;
    }
}
