package com.packt.madev.portfolio.list;

import android.widget.Toast;

import com.packt.madev.core.View;
import com.packt.madev.core.ViewModel;
import com.packt.madev.portfolio.model.PortfolioRepository;


public class StockViewModel extends ViewModel<PortfolioListData> {
    PortfolioRepository portfolioRepository = new PortfolioRepository();

    private PortfolioListData data = new PortfolioListData();
    private StockPortfolioListViewActivity activity;


    public void bind(View<PortfolioListData> activity) {
        this.activity = activity.getActivity();
        data.items = portfolioRepository.getPortfolioItems();
        activity.render(getData());
    }

    public void unbind() {
        this.activity = null;
    }

    @Override
    protected PortfolioListData getData() {
        return data;
    }

    @Override
    protected void setData(PortfolioListData data) {
        this.data = data;
    }

    public void onNewItemAddClick() {
        Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
