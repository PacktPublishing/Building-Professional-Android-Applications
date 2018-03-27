package com.packt.madev.portfolio.list;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.packt.madev.R;
import com.packt.madev.databinding.PortfolioFragmentStockSummaryBinding;

import butterknife.BindView;


public class StockSummaryFragment extends Fragment {

    @BindView(R.id.portfolio_summary_text_1)
    TextView text;
    private PortfolioFragmentStockSummaryBinding binding;

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
        View view = binding.getRoot();
        return view;
    }

    public void render(PortfolioListData data) {
        binding.setData(data);
    }
}
