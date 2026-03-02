package com.google.android.gms.vision;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: renamed from: com.google.android.gms.vision.L */
/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public class C2304L {
    public static final String TAG = "Vision";

    /* JADX INFO: renamed from: v */
    public static int m2397v(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 2)) {
            return LogInstrumentation.m2732v(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public static int m2392d(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 3)) {
            return LogInstrumentation.m2726d(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public static int m2393d(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable(TAG, 3)) {
            return LogInstrumentation.m2727d(TAG, String.format(str, objArr), th);
        }
        return 0;
    }

    /* JADX INFO: renamed from: i */
    public static int m2396i(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 4)) {
            return LogInstrumentation.m2730i(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public static int m2394e(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 6)) {
            return LogInstrumentation.m2728e(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* JADX INFO: renamed from: e */
    public static int m2395e(Throwable th, String str, Object... objArr) {
        if (!Log.isLoggable(TAG, 6)) {
            return 0;
        }
        if (Log.isLoggable(TAG, 3)) {
            return LogInstrumentation.m2729e(TAG, String.format(str, objArr), th);
        }
        String str2 = String.format(str, objArr);
        String strValueOf = String.valueOf(th);
        return LogInstrumentation.m2728e(TAG, new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(strValueOf).length()).append(str2).append(": ").append(strValueOf).toString());
    }

    /* JADX INFO: renamed from: w */
    public static int m2398w(String str, Object... objArr) {
        if (Log.isLoggable(TAG, 5)) {
            return LogInstrumentation.m2734w(TAG, String.format(str, objArr));
        }
        return 0;
    }

    /* JADX INFO: renamed from: w */
    public static int m2399w(Throwable th, String str, Object... objArr) {
        if (!Log.isLoggable(TAG, 5)) {
            return 0;
        }
        if (Log.isLoggable(TAG, 3)) {
            return LogInstrumentation.m2735w(TAG, String.format(str, objArr), th);
        }
        String str2 = String.format(str, objArr);
        String strValueOf = String.valueOf(th);
        return LogInstrumentation.m2734w(TAG, new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(strValueOf).length()).append(str2).append(": ").append(strValueOf).toString());
    }
}
