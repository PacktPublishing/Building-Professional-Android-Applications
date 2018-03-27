package com.packt.madev.portfolio.list;

import com.packt.madev.core.RxError;
import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;
import com.packt.madev.portfolio.addnew.AddNewStockActivity;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class StockViewModel extends ViewModel<PortfolioListData> {

    PortfolioRepository portfolioRepository;

    @Inject
    public StockViewModel(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    private PortfolioListData data = PortfolioListData.create();

    @Override
    public void bind(ViewActivity<PortfolioListData> activity) {
        super.bind(activity);

        portfolioRepository.getPortfolioItems()
                .toList()
                .map(this.data::withItems)
                .subscribe(this::update, RxError::handler);
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
        getActivity().startActivity(AddNewStockActivity.buildIntent(getActivity()));
    }
}
