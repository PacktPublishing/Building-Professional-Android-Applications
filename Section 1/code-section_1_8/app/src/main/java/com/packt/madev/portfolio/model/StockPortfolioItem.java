package com.packt.madev.portfolio.model;

import java.io.Serializable;

public class StockPortfolioItem implements Serializable {
    private String symbol;

    public StockPortfolioItem(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
