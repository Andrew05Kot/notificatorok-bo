package com.kot.notificatorok.api.dto.price;

import com.kot.notificatorok.core.binance.model.PriceModel;

import java.math.BigDecimal;

public class PriceResponse {

    private String symbol;
    private BigDecimal price;

    public PriceResponse() { }

    public PriceResponse(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }
//
//    public PriceResponse(PriceModel model) {
//        PriceResponse response = new PriceResponse();
//        response.setSymbol(model.getSymbol());
//        response.setPrice(model.getPrice());
//        return response;
//    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
