package com.packt.madev.core;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.packt.madev.MainComponent;
import com.packt.madev.ProjectApplication;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.Serializable;

public abstract class ViewActivity<T extends Serializable> extends RxAppCompatActivity {
    protected abstract ViewModel<T> getViewModel();

    protected abstract void render(T data);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().loadSaved(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getViewModel().bind(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getViewModel().saveState(bundle);
    }

    @Override
    protected void onStop() {
        getViewModel().unbind();
        super.onStop();
    }

    public MainComponent getMainComponent() {
        return ((ProjectApplication) getApplication()).getMainComponent();
    }
}
