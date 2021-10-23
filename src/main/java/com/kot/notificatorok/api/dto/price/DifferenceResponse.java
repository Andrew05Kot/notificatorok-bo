package com.kot.notificatorok.api.dto.price;

import java.math.BigDecimal;

public class DifferenceResponse {

    private String symbol;
    private double difference;

    public DifferenceResponse() { }

    public DifferenceResponse(String symbol, double difference) {
        this.symbol = symbol;
        this.difference = difference;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }
}
