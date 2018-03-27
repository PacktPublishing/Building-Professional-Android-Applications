package com.packt.madev.portfolio.data;

import com.packt.madev.portfolio.data.iextrading.IexQuote;

import java.math.BigDecimal;

public class StockPrice {
    private final String symbol;
    private final BigDecimal price;

    public StockPrice(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }

    public static StockPrice create(IexQuote r) {
        return new StockPrice(
                r.symbol,
                r.latestPrice
        );
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
