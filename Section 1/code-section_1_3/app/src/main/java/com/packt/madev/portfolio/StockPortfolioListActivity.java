package com.packt.madev.portfolio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.packt.madev.R;

public class StockPortfolioListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_activity_stock_list);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_1, new StockSummaryFragment())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_2, new StockPortfolioListFragment())
                .commit();
    }
}
