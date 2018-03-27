package com.packt.madev.core;

import android.app.Activity;
import android.os.Bundle;

import com.github.lukaspili.reactivebilling.model.SkuDetails;
import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Analytics {
    @Inject
    FirebaseAnalytics firebaseAnalytics;

    @Inject
    public Analytics() {
    }

    public void logActivity(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, activity.getClass().getSimpleName());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "screen");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    public void logCheckoutStart(String productId) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, productId);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.BEGIN_CHECKOUT, bundle);
    }

    public void logPurchase(SkuDetails skuDetails) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, skuDetails.getProductId());
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, skuDetails.getPriceCurrencyCode());
        bundle.putString(FirebaseAnalytics.Param.PRICE, skuDetails.getPrice());
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, bundle);

    }
}
