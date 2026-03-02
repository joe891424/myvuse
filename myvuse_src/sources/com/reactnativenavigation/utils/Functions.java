package com.reactnativenavigation.utils;

/* JADX INFO: loaded from: classes6.dex */
public class Functions {

    public interface Func {
        void run();
    }

    public interface Func1<T> {
        void run(T t);
    }

    public interface Func2<T, S> {
        void run(T t, S s);
    }

    public interface FuncR<T> {
        T run();
    }

    public interface FuncR1<T, S> {
        S run(T t);
    }

    public interface FuncR2<T, S, R> {
        R run(T t, S s);
    }

    public interface Unit<T> {
        T get();
    }
}
