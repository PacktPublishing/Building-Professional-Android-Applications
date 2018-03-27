package com.packt.madev;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.packt.madev.portfolio.data.iextrading.StockUpdatesService;
import com.packt.madev.portfolio.jobs.PortfolioSyncJob;
import com.packt.madev.portfolio.model.PortfolioRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppJobCreator implements JobCreator {
    @Inject
    public AppJobCreator() {
    }

    @Inject
    PortfolioRepository portfolioRepository;
    @Inject
    StockUpdatesService stockUpdatesService;

    @Override
    @Nullable
    public Job create(@NonNull String tag) {
        switch (tag) {
            case PortfolioSyncJob.TAG:
                return new PortfolioSyncJob(portfolioRepository, stockUpdatesService);
            default:
                return null;
        }
    }
}