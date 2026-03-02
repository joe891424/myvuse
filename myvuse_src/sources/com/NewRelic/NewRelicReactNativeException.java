package com.NewRelic;

/* JADX INFO: loaded from: classes.dex */
public class NewRelicReactNativeException extends Exception {
    public NewRelicReactNativeException(String str, StackTraceElement[] stackTraceElementArr) {
        super(str);
        setStackTrace(stackTraceElementArr);
    }
}
