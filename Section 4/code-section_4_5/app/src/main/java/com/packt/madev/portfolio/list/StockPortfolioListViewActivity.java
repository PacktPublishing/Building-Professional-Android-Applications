package com.packt.madev.portfolio.list;

import android.os.Bundle;

import com.packt.madev.R;
import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class StockPortfolioListViewActivity extends ViewActivity<PortfolioListData> {

    @Inject
    StockViewModel viewModel;

    private StockSummaryFragment stockSummaryFragment;
    private StockPortfolioListFragment stockPortfolioListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
//        getMainComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_activity_stock_list);

        stockSummaryFragment = new StockSummaryFragment();
        stockSummaryFragment.setViewModel(viewModel);
        stockPortfolioListFragment = new StockPortfolioListFragment();
        stockPortfolioListFragment.setViewModel(viewModel);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_1, stockSummaryFragment)
                .replace(R.id.fragment_container_2, stockPortfolioListFragment)
                .commit();

        viewModel.loadSaved(savedInstanceState);
    }


    @Override
    public void render(PortfolioListData data) {
        stockPortfolioListFragment.render(data);
        stockSummaryFragment.render(data);
    }

    @Override
    protected ViewModel<PortfolioListData> getViewModel() {
        return viewModel;
    }

}
