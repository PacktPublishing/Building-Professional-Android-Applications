package com.packt.madev.portfolio.jobs;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.packt.madev.portfolio.data.iextrading.StockUpdatesService;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.model.StockPortfolioItem;

public class PortfolioSyncJob extends Job {

    public static final String TAG = "portfolio_sync_job_updated";

    private final StockUpdatesService stockUpdatesService;
    private final PortfolioRepository portfolioRepository;

    public PortfolioSyncJob(PortfolioRepository portfolioRepository, StockUpdatesService stockUpdatesService) {
        this.portfolioRepository = portfolioRepository;
        this.stockUpdatesService = stockUpdatesService;
    }

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        portfolioRepository.getPortfolioItems()
                .flatMap(
                        (item) -> stockUpdatesService.getQuote(item.getSymbol())
                                .map(update -> Pair.create(item, update))
                )
                .blockingForEach(pair -> {
                    StockPortfolioItem item = pair.first;
                    item.updatePrice(pair.second);
                    portfolioRepository.save(item);
                    Log.i("APP", "Updated " + item.getSymbol() + " to " + item.getLastPrice());
                });

        return Result.SUCCESS;
    }

    public static JobRequest createJob() {
        return new JobRequest.Builder(PortfolioSyncJob.TAG)
                .setUpdateCurrent(true)
//                .setPeriodic(1000_000L, 400_000L)
                .setExact(10L)
                .build();
    }
}