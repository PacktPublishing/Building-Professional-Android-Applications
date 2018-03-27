package com.packt.madev.tutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.packt.madev.ProjectApplication;
import com.packt.madev.R;
import com.packt.madev.core.Settings;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class TutorialStep extends Fragment {

    @Inject
    Settings settings;

    private Unbinder unbinder;

    public static class HelloStep extends TutorialStep {
        @Override
        public CharSequence getTitle() {
            return "Hello";
        }

        @Override
        public int getLayoutResourceId() {
            return R.layout.tutorial_step_hello;
        }
    }

    public static class WhatToDoStep extends TutorialStep {
        @Override
        public CharSequence getTitle() {
            return "What's up";
        }

        @Override
        public int getLayoutResourceId() {
            return R.layout.tutorial_step_what_to_do;
        }
    }

    public static class FinishStep extends TutorialStep {

        @Override
        public CharSequence getTitle() {
            return "Start";
        }

        @OnClick(R.id.tutorial_step_finish_btn)
        public void onClick(View v) {
            settings.markTutorialSeen();
            getActivity().finish();
        }

        @Override
        public int getLayoutResourceId() {
            return R.layout.tutorial_step_finish;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResourceId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((ProjectApplication) getActivity().getApplication()).getMainComponent().inject(this);
    }

    public abstract CharSequence getTitle();

    public abstract int getLayoutResourceId();

}