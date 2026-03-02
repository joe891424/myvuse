package com.reactnativenavigation.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public class UiThread {
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void post(Runnable runnable) {
        handler.post(runnable);
    }

    public static void postDelayed(Runnable runnable, long j) {
        handler.postDelayed(runnable, j);
    }
}
