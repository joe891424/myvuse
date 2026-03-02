package com.reactnativenavigation.utils;

import com.reactnativenavigation.utils.Functions;

/* JADX INFO: loaded from: classes6.dex */
public class LateInit<T> {
    private T value;

    public T get() {
        return this.value;
    }

    public void set(T t) {
        this.value = t;
    }

    public void perform(Functions.Func1<T> func1) {
        T t = this.value;
        if (t != null) {
            func1.run(t);
        }
    }
}
