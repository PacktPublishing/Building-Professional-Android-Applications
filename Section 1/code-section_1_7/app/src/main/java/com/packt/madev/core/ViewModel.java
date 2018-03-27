package com.packt.madev.core;

import android.os.Bundle;
import android.util.Log;

import com.trello.rxlifecycle2.android.ActivityEvent;

import java.io.Serializable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;


public abstract class ViewModel<T extends Serializable> {

    private static final String BUNDLE_KEY = "view-data";
    private BehaviorSubject<T> dataSubject = BehaviorSubject.create();
    private Disposable disposable;
    private ViewActivity<T> activity;

    public void loadSaved(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Serializable data = savedInstanceState.getSerializable(BUNDLE_KEY);
            setData((T) data);
        }
    }

    public void update(T t) {
        dataSubject.onNext(t);
    }


    public void bind(ViewActivity<T> activity) {
        this.activity = activity;
        disposable = activity.lifecycle()
                .filter(activityEvent -> activityEvent.equals(ActivityEvent.START))
                .flatMap((at) -> dataSubject)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(activity::render, this::handleError);
    }

    private void handleError(Throwable throwable) {
        Log.e("APP", "Error", throwable);
    }

    public void unbind() {
        activity = null;
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public ViewActivity<T> getActivity() {
        return activity;
    }

    void saveState(Bundle bundle) {
        bundle.putSerializable(BUNDLE_KEY, getData());
    }

    protected abstract T getData();

    protected abstract void setData(T data);

    private static class MockObject implements Serializable {
    }

    public static ViewModel NULL = new ViewModel() {
        @Override
        protected Serializable getData() {
            return new MockObject();
        }

        @Override
        protected void setData(Serializable data) {

        }
    };
}
