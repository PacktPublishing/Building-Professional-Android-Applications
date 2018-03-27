package com.packt.madev.portfolio;

import android.os.Bundle;

import com.packt.madev.R;
import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;

import java.io.Serializable;

public class AddNewStockActivity extends ViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_activity_add_new_stock);
    }

    @Override
    protected ViewModel getViewModel() {
        return ViewModel.NULL;
    }

    @Override
    public void render(Serializable data) {
    }
}
