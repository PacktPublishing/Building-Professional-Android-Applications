package com.packt.madev;

import com.evernote.android.job.JobManager;
import com.packt.madev.portfolio.jobs.PortfolioSyncJob;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;

import javax.inject.Inject;

public class MainActivity extends StockPortfolioListViewActivity {
    @Inject
    JobManager jobManager;

    @Override
    protected void onStart() {
        super.onStart();
//        jobManager.schedule(PortfolioSyncJob.createJob());
    }
}
