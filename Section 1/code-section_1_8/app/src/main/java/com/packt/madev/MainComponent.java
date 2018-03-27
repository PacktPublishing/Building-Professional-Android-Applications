package com.packt.madev;

import com.packt.madev.portfolio.PortfolioModule;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;
import com.packt.madev.portfolio.list.StockViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        PortfolioModule.class,
})
public interface MainComponent {
    void inject(MainActivity activity);

    void inject(ProjectApplication activity);

    void inject(StockViewModel activity);

    void inject(StockPortfolioListViewActivity activity);
}