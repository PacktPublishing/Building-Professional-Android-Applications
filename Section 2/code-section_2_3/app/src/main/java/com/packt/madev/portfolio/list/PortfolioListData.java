package com.packt.madev.portfolio.list;

import com.google.auto.value.AutoValue;
import com.packt.madev.portfolio.model.StockPortfolioItem;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class PortfolioListData implements Serializable {
    public abstract String getSummaryText();

    public abstract List<StockPortfolioItem> getItems();

    public abstract PortfolioListData withItems(List<StockPortfolioItem> items);

    static PortfolioListData create() {
        return new AutoValue_PortfolioListData("", Collections.emptyList());
    }
}

