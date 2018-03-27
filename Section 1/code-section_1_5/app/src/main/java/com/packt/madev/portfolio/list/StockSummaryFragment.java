package com.packt.madev.portfolio.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.packt.madev.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StockSummaryFragment extends Fragment {

    @BindView(R.id.portfolio_summary_text_1)
    TextView text;

    public StockSummaryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.portfolio_fragment_stock_summary, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void render(PortfolioListData data) {
        text.setText(data.summaryText);
    }
}
