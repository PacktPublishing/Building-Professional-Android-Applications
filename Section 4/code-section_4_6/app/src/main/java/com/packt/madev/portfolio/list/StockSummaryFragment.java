package com.packt.madev.portfolio.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.packt.madev.R;
import com.packt.madev.databinding.PortfolioFragmentStockSummaryBinding;


public class StockSummaryFragment extends Fragment {

    private PortfolioFragmentStockSummaryBinding binding;
    private StockViewModel viewModel;

    public StockSummaryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.portfolio_fragment_stock_summary, container, false);
        binding.setModel(viewModel);

        View view = binding.getRoot();
        return view;
    }

    public void render(PortfolioListData data) {
        binding.setData(data);
    }

    public void setViewModel(StockViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
