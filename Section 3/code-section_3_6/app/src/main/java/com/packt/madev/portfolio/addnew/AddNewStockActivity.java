package com.packt.madev.portfolio.addnew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.packt.madev.R;
import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;

import java.io.Serializable;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AddNewStockActivity extends ViewActivity {

    @Inject
    AddNewItemViewModel viewModel;

    private AddNewStockFragment addNewStockFragment;

    public static Intent buildIntent(Context context) {
        return new Intent(context, AddNewStockActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_activity_add_new_stock);

        addNewStockFragment = new AddNewStockFragment();
        addNewStockFragment.setViewModel(viewModel);

        setTitle("Add New Item");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_1, addNewStockFragment)
                .commit();

        viewModel.loadSaved(savedInstanceState);
        viewModel.bind(this);
    }

    @Override
    protected ViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void render(Serializable data) {
        addNewStockFragment.render(data);
    }
}
