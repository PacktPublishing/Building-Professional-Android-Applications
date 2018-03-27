package com.packt.madev.portfolio.data.iextrading;

import com.packt.madev.portfolio.data.StockPrice;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class StockUpdatesService {
    IexDataService iexDataService = new RetrofitIexServiceFactory().create();

    public Observable<StockPrice> getQuote(String symbol) {
        return iexDataService.getQuote(symbol)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .map(StockPrice::create);
    }

}
