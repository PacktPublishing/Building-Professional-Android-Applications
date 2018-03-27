package com.packt.madev.portfolio.model;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StockPortfolioItemTest {
    @Test
    public void getting_value_should_multiple_count_and_last_price() throws Exception {
        StockPortfolioItem item = preparePortfolioItem();

        item.setLastPrice(new BigDecimal("15.5"));

        assertThat(item.getValue(), equalTo(new BigDecimal("155.0")));
    }

    @Test
    public void when_last_price_is_null_the_value_should_be_null() throws Exception {
        StockPortfolioItem item = preparePortfolioItem();

        assertThat(item.getValue(), nullValue());
    }

    @NonNull
    public StockPortfolioItem preparePortfolioItem() {
        return new StockPortfolioItem("TEST", BigDecimal.TEN, new Date());
    }

}