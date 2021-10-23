package com.kot.notificatorok.core.binance.service.price;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.TickerPrice;
import com.kot.notificatorok.core.binance.model.PriceModel;
import com.kot.notificatorok.core.entity.code.Code;
import com.kot.notificatorok.core.job.BinanceFetcherJob;
import com.kot.notificatorok.core.provider.SettingsProvider;
import com.kot.notificatorok.core.repository.price.PriceRepository;
import com.kot.notificatorok.core.entity.price.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceService.class);

    @Autowired
    private BinanceApiRestClient binanceApiRestClient;

    @Autowired
    private SettingsProvider settingsProvider;

    public PriceModel getCurrentPrice(String symbol) {
        TickerPrice tickerPrice = binanceApiRestClient.getPrice(symbol);
        PriceModel priceModel = new PriceModel();
        priceModel.setSymbol(tickerPrice.getSymbol());
        priceModel.setPrice(new BigDecimal( tickerPrice.getPrice() ));
        return priceModel;
    }

    public double getDifference(String symbol) {
        List<Candlestick> candlestickBars = binanceApiRestClient.getCandlestickBars("BTCUSDT",
                CandlestickInterval.FOUR_HOURLY);
        Double start = new Double(candlestickBars.get(0).getClose());
        Double end = new Double(candlestickBars.get(candlestickBars.size() -1).getClose());
        return start * 100 / end;
    }

}
