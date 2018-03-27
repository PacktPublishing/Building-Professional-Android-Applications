package com.packt.madev.portfolio.list;

import android.widget.Toast;

import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;
import com.packt.madev.portfolio.model.PortfolioRepository;


public class StockViewModel extends ViewModel<PortfolioListData> {
    PortfolioRepository portfolioRepository = new PortfolioRepository();

    private PortfolioListData data = new PortfolioListData();

    @Override
    public void bind(ViewActivity<PortfolioListData> activity) {
        super.bind(activity);

        data.items = portfolioRepository.getPortfolioItems();
        update(data);
    }

    @Override
    public void unbind() {
        super.unbind();
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
        Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
    }
}
