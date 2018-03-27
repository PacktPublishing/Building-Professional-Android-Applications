package com.packt.madev.tutorial;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.packt.madev.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TutorialActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager viewPager;

//    @BindView(R.id.titles)
//    TitlePageIndicator titleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        ButterKnife.bind(this);

        TutorialStepAdapter tutorialStepAdapter
                = new TutorialStepAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tutorialStepAdapter);
//        titleIndicator.setViewPager(viewPager);
    }
}
