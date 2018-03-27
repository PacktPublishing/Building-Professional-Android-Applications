package com.packt.madev.portfolio.model;


import com.packt.madev.database.BigDecimalConverter;
import com.packt.madev.portfolio.data.StockPrice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class StockPortfolioItem implements Serializable {

    @Id
    Long id;

    private String symbol;
    private Date dateAdded;

    @Convert(converter = BigDecimalConverter.class, dbType = Long.class)
    private BigDecimal shareCount;
    @Convert(converter = BigDecimalConverter.class, dbType = Long.class)
    private BigDecimal lastPrice;

    StockPortfolioItem() {
    }

    public StockPortfolioItem(String symbol, BigDecimal shareCount, Date dateAdded) {
        this.symbol = symbol;
        this.shareCount = shareCount;
        this.dateAdded = dateAdded;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateAdded() {
        return dateAdded;
    }

    public BigDecimal getShareCount() {
        return shareCount;
    }

    public BigDecimal getValue() {
        if (shareCount == null || lastPrice == null) {
            return null;
        }

        return this.lastPrice.multiply(this.shareCount);
    }
}
