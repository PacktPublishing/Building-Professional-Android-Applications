package com.packt.madev.portfolio.model;


import java.util.Arrays;
import java.util.List;

public class PortfolioRepository {

    public List<StockPortfolioItem> getPortfolioItems() {
        return Arrays.asList(
                new StockPortfolioItem("GOOGLE"),
                new StockPortfolioItem("MSFT"),
                new StockPortfolioItem("TWTR")
        );
    }

}
