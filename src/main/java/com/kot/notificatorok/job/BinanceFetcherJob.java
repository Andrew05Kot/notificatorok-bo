package com.kot.notificatorok.job;

import com.kot.notificatorok.service.code.CodeService;
import com.kot.notificatorok.service.price.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class BinanceFetcherJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinanceFetcherJob.class);

    @Autowired
    private CodeService codeService;

    @Autowired
    private PriceService priceService;
//
//    @Autowired
//    private BinanceApiRestClient binanceApiRestClient;

//    @Scheduled(fixedRate = 60000)
    private void call() {
        System.out.println("hello");
//        List<TickerPrice> tickerPrices = binanceApiRestClient.getAllPrices();
//        tickerPrices.forEach(tickerPrice -> {
//            String codeName = null;
//            BigDecimal price = BigDecimal.ZERO;
//            try {
//                codeName = tickerPrice.getSymbol();
//                Code code = codeService.get(codeName);
//                price = new BigDecimal( tickerPrice.getPrice() );
//                priceService.save(code, price, LocalDateTime.now());
//            } catch (Exception e) {
//                LOGGER.error("Code: {}, Prise: {}, Exception: {}", codeName, price, e.getMessage());
//            }
//        });
    }

}
