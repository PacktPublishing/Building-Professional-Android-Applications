package com.packt.madev.portfolio.list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.packt.madev.R;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.util.ArrayList;
import java.util.List;


public class StockPortfolioListFragment extends Fragment {


    RecyclerView mRecyclerView;
    FloatingActionButton addNewItemButton;
    StockViewModel viewModel;

    private List<StockPortfolioItem> items = new ArrayList<>();
    private ListAdapter mAdapter = new ListAdapter(items);

    public StockPortfolioListFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.portfolio_fragment_stock_list, container, false);

        mRecyclerView = view.findViewById(R.id.portfolio_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this.getContext())
        );

        mRecyclerView.setAdapter(mAdapter);

        addNewItemButton = view.findViewById(R.id.portfolio_btn_add_new_item);
        addNewItemButton.setOnClickListener(v -> {
            viewModel.onNewItemAddClick();
        });

        return view;
    }

    public void setViewModel(StockViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void render(PortfolioListData data) {
        mAdapter.setItems(data.items);
        mAdapter.notifyDataSetChanged();
    }
}
