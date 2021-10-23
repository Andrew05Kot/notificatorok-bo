//package com.kot.notificatorok.core.binance.config;
//
//import com.binance.api.client.BinanceApiClientFactory;
//import com.binance.api.client.BinanceApiRestClient;
//import com.kot.notificatorok.core.binance.provider.SettingsProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@Configuration
//public class BinanceRestConfig {
//
//    @Autowired
//    private SettingsProvider provider;
//
//    @Bean
//    public BinanceApiRestClient binanceApiRestClient() {
//        return BinanceApiClientFactory
//                .newInstance(provider.getApiKey(), provider.getSecretKey())
//                .newRestClient();
//    }
//}
