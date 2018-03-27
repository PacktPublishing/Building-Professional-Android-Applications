package com.packt.madev.core;


import android.app.Activity;

import java.io.Serializable;

public interface View<T extends Serializable> {
    void render(T data);

    <C extends Activity> C getActivity();
}
