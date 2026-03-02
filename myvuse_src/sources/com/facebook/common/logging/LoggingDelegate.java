package com.facebook.common.logging;

/* JADX INFO: loaded from: classes3.dex */
public interface LoggingDelegate {
    /* JADX INFO: renamed from: d */
    void mo1321d(String str, String str2);

    /* JADX INFO: renamed from: d */
    void mo1322d(String str, String str2, Throwable th);

    /* JADX INFO: renamed from: e */
    void mo1323e(String str, String str2);

    /* JADX INFO: renamed from: e */
    void mo1324e(String str, String str2, Throwable th);

    int getMinimumLoggingLevel();

    /* JADX INFO: renamed from: i */
    void mo1325i(String str, String str2);

    /* JADX INFO: renamed from: i */
    void mo1326i(String str, String str2, Throwable th);

    boolean isLoggable(int i);

    void log(int i, String str, String str2);

    void setMinimumLoggingLevel(int i);

    /* JADX INFO: renamed from: v */
    void mo1327v(String str, String str2);

    /* JADX INFO: renamed from: v */
    void mo1328v(String str, String str2, Throwable th);

    /* JADX INFO: renamed from: w */
    void mo1329w(String str, String str2);

    /* JADX INFO: renamed from: w */
    void mo1330w(String str, String str2, Throwable th);

    void wtf(String str, String str2);

    void wtf(String str, String str2, Throwable th);
}
