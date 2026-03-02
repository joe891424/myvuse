package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class Optional<T> {
    private final T value;

    private Optional() {
        this.value = null;
    }

    private Optional(T t) {
        if (t == null) {
            throw new NullPointerException("value for optional is empty.");
        }
        this.value = t;
    }

    public static <T> Optional<T> absent() {
        return new Optional<>();
    }

    /* JADX INFO: renamed from: of */
    public static <T> Optional<T> m2667of(T t) {
        return new Optional<>(t);
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : m2667of(t);
    }

    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean isAvailable() {
        return this.value != null;
    }
}
