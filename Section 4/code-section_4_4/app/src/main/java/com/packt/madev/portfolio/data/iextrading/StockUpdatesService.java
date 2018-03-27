package com.packt.madev.portfolio.data.iextrading;

import com.packt.madev.portfolio.data.StockPrice;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class StockUpdatesService {
    @Inject
    IexDataService iexDataService;

    @Inject
    public StockUpdatesService() {
    }

    public Observable<StockPrice> getQuote(String symbol) {
        return iexDataService.getQuote(symbol)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .map(StockPrice::create);
    }

}
