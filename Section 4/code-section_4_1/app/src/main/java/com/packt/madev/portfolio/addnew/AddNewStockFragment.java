package com.packt.madev.portfolio.addnew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.packt.madev.R;
import com.packt.madev.portfolio.list.StockViewModel;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.io.Serializable;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class AddNewStockFragment extends RxFragment {

    private AddNewItemViewModel viewModel;
    private Unbinder unbinder;

    @BindView(R.id.portfolio_addnew_symbol)
    EditText symbol;

    @BindView(R.id.portfolio_addnews_share_count)
    EditText shareCount;

    public AddNewStockFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.portfolio_fragment_add_new_stock, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @OnClick(R.id.portfolio_addnew_button)
    public void addNewButton() {
        String symbolName = this.symbol.getText().toString();
        BigDecimal shareCount = new BigDecimal(this.shareCount.getText().toString());
        viewModel.addNewStock(symbolName, shareCount);
    }

    public void setViewModel(AddNewItemViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void render(Serializable data) {
    }
}
