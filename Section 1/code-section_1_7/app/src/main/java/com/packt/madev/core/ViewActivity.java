package com.packt.madev.core;

import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.Serializable;

public abstract class ViewActivity<T extends Serializable> extends RxAppCompatActivity {
    protected abstract ViewModel<T> getViewModel();

    protected abstract void render(T data);

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

}
