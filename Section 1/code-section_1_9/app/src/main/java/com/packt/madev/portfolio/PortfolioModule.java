package com.packt.madev.portfolio;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.packt.madev.portfolio.data.iextrading.IexDataService;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = PortfolioModule.PortfolioViewsModule.class)
public class PortfolioModule {

    @Module
    public static abstract class PortfolioViewsModule {
        @ContributesAndroidInjector
        abstract StockPortfolioListViewActivity contributeActivityInjector();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.iextrading.com/1.0/")
                .build();
    }

    @Provides
    @Singleton
    IexDataService provideIexDataService(Retrofit retrofit) {
        return retrofit.create(IexDataService.class);
    }
}