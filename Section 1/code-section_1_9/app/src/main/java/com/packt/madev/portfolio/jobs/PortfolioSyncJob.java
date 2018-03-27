package com.packt.madev.portfolio.jobs;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.packt.madev.portfolio.data.iextrading.StockUpdatesService;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.util.List;

import io.reactivex.Observable;

public class PortfolioSyncJob extends Job {

    public static final String TAG = "portfolio_sync_job";

    private final StockUpdatesService stockUpdatesService;
    private final PortfolioRepository portfolioRepository;

    public PortfolioSyncJob(PortfolioRepository portfolioRepository, StockUpdatesService stockUpdatesService) {
        this.portfolioRepository = portfolioRepository;
        this.stockUpdatesService = stockUpdatesService;
    }

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        List<StockPortfolioItem> portfolioItems = portfolioRepository.getPortfolioItems();
        Observable.fromIterable(portfolioItems)
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
//                .setPeriodic(10_000L, 40_000L)
                .setExact(10L)
                .build();
    }
}