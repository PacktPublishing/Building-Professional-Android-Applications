package com.packt.madev;

import android.util.Log;

import com.packt.madev.portfolio.data.iextrading.StockUpdatesService;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;

public class MainActivity extends StockPortfolioListViewActivity {
    @Override
    protected void onStart() {
        super.onStart();
        new StockUpdatesService().getQuote("msft")
                .subscribe((item) -> Log.i("APP", item.getSymbol() + " " + item.getPrice()));
    }
}
