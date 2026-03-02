package com.google.firebase.crashlytics.ndk;

import com.google.firebase.crashlytics.internal.Logger;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes2.dex */
public class CrashpadMain {
    public static native void crashpadMain(String[] strArr);

    public static void main(String[] strArr) {
        try {
            String str = strArr[1];
            LogInstrumentation.m2726d(Logger.TAG, "Path to shared objects is " + str);
            System.load(str + "libcrashlytics-handler.so");
            crashpadMain(strArr);
        } catch (UnsatisfiedLinkError e) {
            throw new RuntimeException(e);
        }
    }
}
