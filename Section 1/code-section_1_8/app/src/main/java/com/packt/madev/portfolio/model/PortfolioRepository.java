package com.packt.madev.portfolio.model;


import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PortfolioRepository {
    @Inject
    public PortfolioRepository() {
    }

    public List<StockPortfolioItem> getPortfolioItems() {
        return Arrays.asList(
                new StockPortfolioItem("GOOGLE"),
                new StockPortfolioItem("MSFT"),
                new StockPortfolioItem("TWTR")
        );
    }

}
