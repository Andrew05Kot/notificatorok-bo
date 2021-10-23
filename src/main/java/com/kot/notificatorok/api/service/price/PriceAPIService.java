package com.kot.notificatorok.api.service.price;

import com.kot.notificatorok.api.dto.price.DifferenceResponse;
import com.kot.notificatorok.api.dto.price.PriceResponse;
import com.kot.notificatorok.core.binance.model.PriceModel;
import com.kot.notificatorok.core.binance.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceAPIService {

    @Autowired
    private PriceService service;

    public PriceResponse getCurrentPrice(String symbol) {
        PriceModel priceModel = service.getCurrentPrice(symbol);
        return new PriceResponse(priceModel.getSymbol(), priceModel.getPrice());
    }

    public DifferenceResponse getDifference(String symbol) {
        double difference = service.getDifference(symbol);
        return new DifferenceResponse(symbol, difference);
    }

}
