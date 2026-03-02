package com.qualtrics.digital;

/* JADX INFO: loaded from: classes6.dex */
class CrashReporter {
    CrashReporter() {
    }

    static void logCrash(Throwable th) {
        SiteInterceptService.instance().postErrorLog(th);
    }

    static void logCrash(String str, Throwable th) {
        SiteInterceptService.instance().postErrorLog(str, false, th);
    }
}
