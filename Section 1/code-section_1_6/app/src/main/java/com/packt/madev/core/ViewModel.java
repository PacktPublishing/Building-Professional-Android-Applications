package com.packt.madev.core;

import android.os.Bundle;

import java.io.Serializable;


public abstract class ViewModel<T extends Serializable> {
    private static final String BUNDLE_KEY = "view-data";


    public void loadSaved(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Serializable data = savedInstanceState.getSerializable(BUNDLE_KEY);
            setData((T) data);
        }
    }


    public abstract void bind(View<T> activity);

    public abstract void unbind();

    public void saveState(Bundle bundle) {
        bundle.putSerializable(BUNDLE_KEY, getData());
    }

    protected abstract T getData();

    protected abstract void setData(T data);
}
