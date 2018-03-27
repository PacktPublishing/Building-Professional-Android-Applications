package com.packt.madev.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.packt.madev.R;
import com.trello.rxlifecycle2.components.support.RxFragment;


public class AddNewStockFragment extends RxFragment {

    public AddNewStockFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.portfolio_fragment_stock_list, container, false);
    }


}
