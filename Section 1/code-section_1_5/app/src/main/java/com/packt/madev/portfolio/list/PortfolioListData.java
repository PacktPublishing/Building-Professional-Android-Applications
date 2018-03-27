package com.packt.madev.portfolio.list;

import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


public class PortfolioListData implements Serializable {
    public String summaryText = "This is an example";
    public List<StockPortfolioItem> items = Collections.emptyList();
}
