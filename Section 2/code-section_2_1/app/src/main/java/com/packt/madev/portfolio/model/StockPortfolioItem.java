package com.packt.madev.portfolio.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.packt.madev.portfolio.data.StockPrice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class StockPortfolioItem implements Serializable {

    @PrimaryKey(autoGenerate = true)
    Long id;

    private String symbol;
    private Date dateAdded;
    private BigDecimal shareCount;

    private BigDecimal lastPrice;

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
