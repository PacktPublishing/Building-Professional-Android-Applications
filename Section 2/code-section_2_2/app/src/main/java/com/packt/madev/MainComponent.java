package com.packt.madev;

import com.packt.madev.database.ObjectBoxModule;
import com.packt.madev.portfolio.PortfolioModule;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;
import com.packt.madev.portfolio.list.StockViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        JobsModule.class,
        PortfolioModule.class,
        ObjectBoxModule.class,
})
public interface MainComponent {
    void inject(MainActivity activity);

    void inject(ProjectApplication activity);

    void inject(StockViewModel activity);

    void inject(StockPortfolioListViewActivity activity);

    AppJobCreator getJobCreator();
}