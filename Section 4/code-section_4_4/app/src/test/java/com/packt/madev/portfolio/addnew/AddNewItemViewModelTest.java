package com.packt.madev.portfolio.addnew;

import android.app.Activity;

import com.packt.madev.core.ViewActivity;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.model.StockPortfolioItem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddNewItemViewModelTest {
    private AddNewItemViewModel viewModel;

    @Mock
    PortfolioRepository portfolioRepository;

    @Mock
    ViewActivity activity;

    @Before
    public void setUp() {
        viewModel = new AddNewItemViewModel();
        viewModel.setPortfolioRepository(portfolioRepository);
        viewModel.setActivity(activity);
    }

    @Test
    public void verifyPersistenceCalls() {
        viewModel.addNewStock("GOOG", BigDecimal.ONE);

        verify(portfolioRepository, atLeast(1))
                .save(any(StockPortfolioItem.class));
    }

    @Test
    public void verifyActivityBeingClosed() {
        viewModel.addNewStock("GOOG", BigDecimal.ONE);

        verify(activity, only()).finish();
    }
}