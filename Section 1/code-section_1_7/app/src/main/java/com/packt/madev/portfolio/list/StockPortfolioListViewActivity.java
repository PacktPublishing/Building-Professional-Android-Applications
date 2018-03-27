package com.packt.madev.portfolio.list;

import android.os.Bundle;

import com.packt.madev.R;
import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;


public class StockPortfolioListViewActivity extends ViewActivity<PortfolioListData> {

    private StockViewModel viewModel = new StockViewModel();

    private StockSummaryFragment stockSummaryFragment;
    private StockPortfolioListFragment stockPortfolioListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_activity_stock_list);

        stockSummaryFragment = new StockSummaryFragment();
        stockPortfolioListFragment = new StockPortfolioListFragment();
        stockPortfolioListFragment.setViewModel(viewModel);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_1, stockSummaryFragment)
                .replace(R.id.fragment_container_2, stockPortfolioListFragment)
                .commit();

        viewModel.loadSaved(savedInstanceState);
        viewModel.bind(this);
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
