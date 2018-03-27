package com.packt.madev.portfolio.list;

import com.google.auto.value.AutoValue;
import com.packt.madev.portfolio.model.StockPortfolioItem;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class PortfolioListData implements Serializable {

    public abstract boolean isSummaryActive();

    public abstract List<StockPortfolioItem> getItems();

    public abstract PortfolioListData withItems(List<StockPortfolioItem> items);

    public abstract PortfolioListData withSummaryActive(boolean summaryActive);

    static PortfolioListData create() {
        return new AutoValue_PortfolioListData(false, Collections.emptyList());
    }

    public String getPortfolioValue() {
        float value = 0.0f;
        for (StockPortfolioItem item : getItems()) {
            if (item.getValue() == null) {
                continue;
            }
            value += item.getValue().floatValue();
        }
        return String.format("$%.2f", value);
    }
}

