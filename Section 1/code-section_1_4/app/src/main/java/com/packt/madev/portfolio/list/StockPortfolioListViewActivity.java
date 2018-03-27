package com.packt.madev.portfolio.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.packt.madev.R;
import com.packt.madev.core.View;


public class StockPortfolioListViewActivity extends AppCompatActivity
        implements View<PortfolioListData> {

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.bind(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        viewModel.saveState(bundle);
    }

    @Override
    protected void onStop() {
        viewModel.unbind();
        super.onStop();
    }

    @Override
    public void render(PortfolioListData data) {
        stockPortfolioListFragment.render(data);
        stockSummaryFragment.render(data);
    }

    @Override
    public StockPortfolioListViewActivity getActivity() {
        return this;
    }

}
