package com.packt.madev.core;

import android.util.Log;

public class RxError {
    public static void handler(Throwable throwable) {
        Log.e("APP", "RxException: ", throwable);
    }
}
