package com.packt.madev.database;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.packt.madev.portfolio.model.PortfolioRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                AppDatabase.class,
                "database-name"
        ).build();
    }

    @Provides
    @Singleton
    PortfolioRepository.RoomPortfolioRepository providePortfolioRepository(AppDatabase appDatabase) {
        return appDatabase.portfolioRepository();
    }
}
