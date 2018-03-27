package com.packt.madev.database;


import android.app.Application;

import com.packt.madev.portfolio.model.MyObjectBox;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;

@Module
public class ObjectBoxModule {

    @Provides
    @Singleton
    BoxStore provideAppDatabase(Application application) {
        return MyObjectBox.builder().androidContext(application).build();
    }

    @Provides
    @Named("stockPortfolioItem")
    @Singleton
    Box<StockPortfolioItem> providePortfolioRepository(BoxStore boxStore) {
        return boxStore.boxFor(StockPortfolioItem.class);
    }
}
