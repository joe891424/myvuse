package com.masteratul.exceptionhandler;

import java.lang.Thread;

/* JADX INFO: loaded from: classes2.dex */
public interface NativeExceptionHandlerIfc {
    void handleNativeException(Thread thread, Throwable th, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
