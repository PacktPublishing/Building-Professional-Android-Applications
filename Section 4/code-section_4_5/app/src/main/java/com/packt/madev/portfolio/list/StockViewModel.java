package com.packt.madev.portfolio.list;

import android.util.Log;
import android.view.View;

import com.packt.madev.core.RxError;
import com.packt.madev.core.ViewActivity;
import com.packt.madev.core.ViewModel;
import com.packt.madev.portfolio.addnew.AddNewStockActivity;
import com.packt.madev.portfolio.model.PortfolioRepository;
import com.packt.madev.portfolio.purchases.PurchasesService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class StockViewModel extends ViewModel<PortfolioListData> {

    @Inject
    PortfolioRepository portfolioRepository;

    @Inject
    PurchasesService purchasesService;
    private CompositeDisposable disposable;

    @Inject
    public StockViewModel() {
    }

    private PortfolioListData data = PortfolioListData.create();

    @Override
    public void bind(ViewActivity<PortfolioListData> activity) {
        super.bind(activity);
        disposable = new CompositeDisposable();

        Disposable subscribe = Observable.combineLatest(
                portfolioRepository.getPortfolioItems()
                        .toList()
                        .toObservable(),
                purchasesService.monitorPurchases(getActivity()),
                (items, hasPurchases) -> data.withItems(items).withSummaryActive(hasPurchases)
        )
                .subscribe(this::update, RxError::handler);

        disposable.addAll(
                subscribe
        );
    }

    @Override
    public void unbind() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }

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

    public void onPurchaseRequest(View view) {
        purchasesService.purchasePremium(getActivity())
                .subscribe(response -> {
                            if (response.isSuccess()) {
                                Log.i("APP", "Purchase completed " + response.getResponseCode());
                            } else {
                                Log.w("APP", "" + response.getResponseCode());
                            }
                        }, RxError::handler
                );
    }
}
