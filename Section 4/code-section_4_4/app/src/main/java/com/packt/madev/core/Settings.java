package com.packt.madev.core;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Settings {
    static final String TUTORIAL_KEY = "TUTORIAL";

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    public Settings() {
    }

    public boolean hasSeenTutorial() {
        return sharedPreferences.getBoolean(TUTORIAL_KEY, false);
    }

    public void markTutorialSeen() {
        sharedPreferences.edit()
                .putBoolean(TUTORIAL_KEY, true)
                .commit();
    }
}
