package com.packt.madev.portfolio.model;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.packt.madev.core.RxError;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class PortfolioRepository {

    @Inject
    RoomPortfolioRepository roomPortfolioRepository;

    @Inject
    public PortfolioRepository() {
    }

    public Observable<StockPortfolioItem> getPortfolioItems() {
        return Observable.just("1")
                .flatMap(s -> Observable.fromIterable(roomPortfolioRepository.getPortfolioItems()))
                .subscribeOn(Schedulers.io());
    }

    public void save(StockPortfolioItem item) {
        Observable.just(item)
                .subscribeOn(Schedulers.io())
                .subscribe(item1 -> {
                    if (item1.getId() == null) {
                        roomPortfolioRepository.insert(item1);
                    } else {
                        roomPortfolioRepository.update(item1);
                    }
                }, RxError::handler);
    }


    @Dao
    public interface RoomPortfolioRepository {
        @Query("SELECT * FROM StockPortfolioItem")
        List<StockPortfolioItem> getPortfolioItems();

        @Insert
        void insert(StockPortfolioItem item);

        @Update
        void update(StockPortfolioItem item);
    }
}