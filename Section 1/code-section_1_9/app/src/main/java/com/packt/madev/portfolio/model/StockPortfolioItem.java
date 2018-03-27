package com.packt.madev.portfolio.model;

import com.packt.madev.portfolio.data.StockPrice;

import java.io.Serializable;
import java.math.BigDecimal;

public class StockPortfolioItem implements Serializable {
    private String symbol;
    private BigDecimal lastPrice;

    public StockPortfolioItem(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public void updatePrice(StockPrice stockPrice) {
        this.lastPrice = stockPrice.getPrice();
    }
}
