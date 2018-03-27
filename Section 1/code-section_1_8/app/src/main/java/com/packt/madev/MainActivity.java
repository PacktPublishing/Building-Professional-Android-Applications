package com.packt.madev;

import android.util.Log;

import com.packt.madev.portfolio.data.iextrading.StockUpdatesService;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;

import javax.inject.Inject;

public class MainActivity extends StockPortfolioListViewActivity {
    @Inject
    StockUpdatesService stockUpdatesService;

    @Override
    protected void onStart() {
        super.onStart();
        stockUpdatesService.getQuote("msft")
                .subscribe((item) -> Log.i("APP", item.getSymbol() + " " + item.getPrice()));
    }
}
