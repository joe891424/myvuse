package com.reactnativenavigation.utils;

import androidx.core.view.WindowInsetsCompat;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes6.dex */
public class WindowInsetsUtils {
    private static final String TAG = "GUYCA";

    public static void log(WindowInsetsCompat windowInsetsCompat) {
        LogInstrumentation.m2730i(TAG, "t: " + windowInsetsCompat.getStableInsetTop() + " sysT: " + windowInsetsCompat.getSystemWindowInsetTop() + " b: " + windowInsetsCompat.getStableInsetBottom() + " sysB: " + windowInsetsCompat.getSystemWindowInsetBottom());
    }
}
