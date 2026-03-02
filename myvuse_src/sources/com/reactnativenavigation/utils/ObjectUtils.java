package com.reactnativenavigation.utils;

import com.reactnativenavigation.utils.Functions;

/* JADX INFO: loaded from: classes6.dex */
public class ObjectUtils {
    public static boolean notNull(Object obj) {
        return obj != null;
    }

    public static <T> T take(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static <T> void perform(T t, Functions.Func1<T> func1) {
        if (t != null) {
            func1.run(t);
        }
    }

    public static <T, S> S perform(T t, S s, Functions.FuncR1<T, S> funcR1) {
        return t == null ? s : funcR1.run(t);
    }

    public static <T> T getOrCreate(T t, Functions.FuncR<T> funcR) {
        return t == null ? funcR.run() : t;
    }

    public static <T> boolean equalsNotNull(T t, T t2) {
        return t != null && t.equals(t2);
    }
}
