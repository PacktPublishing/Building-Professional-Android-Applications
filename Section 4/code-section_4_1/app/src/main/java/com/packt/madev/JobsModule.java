package com.packt.madev;

import android.app.Application;

import com.evernote.android.job.JobManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class JobsModule {
    @Provides
    @Singleton
    JobManager provideJobManager(Application application, AppJobCreator jobCreator) {
        JobManager.create(application).addJobCreator(jobCreator);
        return JobManager.instance();
    }
}