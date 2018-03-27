package com.packt.madev.portfolio.model;


import com.packt.madev.core.RxError;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.objectbox.rx.RxQuery;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class PortfolioRepository {

    @Inject
    @Named("stockPortfolioItem")
    Box<StockPortfolioItem> portfolioItemBox;

    @Inject
    public PortfolioRepository() {
    }

    public Observable<StockPortfolioItem> getPortfolioItems() {
        Query<StockPortfolioItem> query = portfolioItemBox.query()
                .build();

        return RxQuery.observable(query)
                .take(1)
                .flatMap(Observable::fromIterable);
    }

    public void save(StockPortfolioItem item) {
//        portfolioItemBox.put(item);
        Observable.just(item)
                .subscribeOn(Schedulers.io())
                .subscribe(portfolioItemBox::put, RxError::handler);
    }


}