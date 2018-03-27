package com.packt.madev.tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TutorialStepAdapter extends FragmentStatePagerAdapter {
    ArrayList<TutorialStep> pages = new ArrayList<TutorialStep>() {
        {
            add(new TutorialStep.HelloStep());
            add(new TutorialStep.WhatToDoStep());
            add(new TutorialStep.FinishStep());
        }
    };

    public TutorialStepAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return pages.get(i);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).getTitle();
    }
}