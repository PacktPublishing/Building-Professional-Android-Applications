package com.packt.madev.portfolio.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.packt.madev.R;


public class StockSummaryFragment extends Fragment {

    private TextView text;

    public StockSummaryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.portfolio_fragment_stock_summary, container, false);
        text = view.findViewById(R.id.portfolio_summary_text_1);
        return view;
    }

    public void render(PortfolioListData data) {
        text.setText(data.summaryText);
    }
}
