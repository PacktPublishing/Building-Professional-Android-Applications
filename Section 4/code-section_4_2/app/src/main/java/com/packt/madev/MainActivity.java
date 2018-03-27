package com.packt.madev;

import android.content.Intent;

import com.evernote.android.job.JobManager;
import com.packt.madev.core.Settings;
import com.packt.madev.portfolio.jobs.PortfolioSyncJob;
import com.packt.madev.portfolio.list.StockPortfolioListViewActivity;
import com.packt.madev.tutorial.TutorialActivity;

import javax.inject.Inject;

public class MainActivity extends StockPortfolioListViewActivity {
    @Inject
    JobManager jobManager;
    @Inject
    Settings settings;

    @Override
    protected void onStart() {
        super.onStart();
        if (!settings.hasSeenTutorial()) {
            startActivity(new Intent(this, TutorialActivity.class));
        }
//        jobManager.schedule(PortfolioSyncJob.createJob());
    }
}
