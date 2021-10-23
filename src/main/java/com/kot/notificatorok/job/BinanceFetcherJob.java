package com.kot.notificatorok.job;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.TickerPrice;
import com.kot.notificatorok.entity.code.Code;
import com.kot.notificatorok.provider.SettingsProvider;
import com.kot.notificatorok.service.code.CodeService;
import com.kot.notificatorok.service.price.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling
public class BinanceFetcherJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinanceFetcherJob.class);

    @Autowired
    private CodeService codeService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private BinanceApiRestClient binanceApiRestClient;

    @Autowired
    private SettingsProvider settingsProvider;

//    @Scheduled(fixedRate = 24000)
    private void call() {
        System.out.println();
        List<TickerPrice> tickerPrices = binanceApiRestClient.getAllPrices();
        tickerPrices.forEach(tickerPrice -> {
            String codeName = null;
            BigDecimal price = BigDecimal.ZERO;
            try {
                codeName = tickerPrice.getSymbol();
                Code code = codeService.get(codeName);
                price = new BigDecimal( tickerPrice.getPrice() );
                LOGGER.info("Saved price: {}", price);
                priceService.save(code,
                        price.toBigInteger(),
                        LocalDateTime.now());
            } catch (Exception e) {
                LOGGER.error("Code: {}, Prise: {}, Exception: {}", codeName, price, e.getMessage());
            }
        });
    }

    @Scheduled(fixedRate = 24000)
    private void getPrice() {
        System.out.println();
        TickerPrice tickerPrice = binanceApiRestClient.getPrice("BTCUSDT");
        LOGGER.info("Saved price: {} and symbol {}", tickerPrice.getSymbol(), tickerPrice.getPrice());

    }

    @Scheduled(fixedRate = 24000)
    private void getPriceDifference() {
        System.out.println();
        List<Candlestick> candlestickBars = binanceApiRestClient.getCandlestickBars("BTCUSDT",
                CandlestickInterval.FOUR_HOURLY);
//        LOGGER.info("candlestickBars \n {} \n {}", candlestickBars.get(0), candlestickBars.get(candlestickBars.size() -1));
        BigDecimal start = new BigDecimal(candlestickBars.get(0).getClose());
        BigDecimal end = new BigDecimal(candlestickBars.get(candlestickBars.size() -1).getClose());
//        System.out.println(candlestickBars.get(0).getClose());
        BigDecimal someValue = start.multiply(BigDecimal.valueOf(100d));
        System.out.println(someValue.divide(end, 6, RoundingMode.DOWN));

//        System.out.println();
    }

}
