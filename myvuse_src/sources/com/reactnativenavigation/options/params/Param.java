package com.reactnativenavigation.options.params;

import com.reactnativenavigation.utils.ObjectUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Param<T> {
    private boolean consumed;
    protected T value;

    public boolean canApplyValue() {
        return true;
    }

    Param(T t) {
        this.value = t;
    }

    public T getAndConsume() {
        T t = get();
        this.consumed = true;
        return t;
    }

    public void consume() {
        this.consumed = true;
    }

    public T get() {
        if (hasValue()) {
            return this.value;
        }
        throw new RuntimeException("Tried to get null value!");
    }

    public T get(T t) {
        return hasValue() ? this.value : t;
    }

    public boolean hasValue() {
        return (this.value == null || this.consumed) ? false : true;
    }

    public boolean equals(Param param) {
        T t = this.value;
        T t2 = param.value;
        return t == t2 || ObjectUtils.equalsNotNull(t, t2);
    }
}
