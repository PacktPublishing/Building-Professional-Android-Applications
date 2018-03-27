package com.packt.madev.portfolio.addnew;

import android.support.annotation.VisibleForTesting;

import com.packt.madev.core.ViewModel;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

public class AddNewItemViewModel extends ViewModel {
    @Inject
    PortfolioRepository portfolioRepository;

    @Inject
    public AddNewItemViewModel() {
    }

    @Override
    protected Serializable getData() {
        return ViewModel.NULL_DATA;
    }

    @Override
    protected void setData(Serializable data) {

    }

    public void addNewStock(String symbolName, BigDecimal shareCount) {
        Date date = new Date();

        StockPortfolioItem item = new StockPortfolioItem(
                symbolName,
                shareCount,
                date
        );

        portfolioRepository.save(item);

        getActivity().finish();
    }

    @VisibleForTesting
    public void setPortfolioRepository(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
}
