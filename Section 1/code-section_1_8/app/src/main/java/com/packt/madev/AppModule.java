package com.packt.madev;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AppModule.Activities.class)
public class AppModule {

    @Module
    public static abstract class Activities {
        @ContributesAndroidInjector
        abstract MainActivity contributeActivityInjector();
    }

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}